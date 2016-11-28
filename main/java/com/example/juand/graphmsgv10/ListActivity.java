package com.example.juand.graphmsgv10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    ListView listBluetooth;
    String[] listDevices;
    ArrayAdapter<String> adapter;
    String nombreUs;
    Button btnConver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nombreUs=getIntent().getExtras().getString("nombrePer");
        listBluetooth = (ListView)findViewById(R.id.listDevices);
        Bundle bundle = getIntent().getExtras();
        listDevices = bundle.getStringArray("list_devices");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listDevices);
        listBluetooth.setAdapter(adapter);
        btnConver=(Button)findViewById(R.id.btnConver);
        btnConver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Iniciar la conversación con los dispositivos emparejados.",Toast.LENGTH_LONG).show();
                Intent intent3=new Intent(ListActivity.this,ConversationActivity.class);
                intent3.putExtra("NomPer",nombreUs);
                startActivity(intent3);
            }
        });
    }
}
//listBluetooth.setVisibility(View.VISIBLE);
