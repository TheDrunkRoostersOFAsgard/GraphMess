package com.example.juand.graphmsgv10;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ProfilePictureView;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.juand.graphmsgv10.LoginActivity.LoginBtn;

public class ConversationActivity extends AppCompatActivity {
    String nombreP;
    Button btnConectar;
    EditText etMessage;
    Button bSend;
    ListView listMsjs;
    TextView txtConfirm,txtAviso;
    ArrayList<String> listamsj;
    ArrayAdapter<String> adapter;
    String msjServer = null;
    DataOutputStream salida;
    DataInputStream entrada;
    Socket cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nombreP=getIntent().getExtras().getString("NomPer");
        etMessage=(EditText)findViewById(R.id.etMessage);
        listMsjs=(ListView)findViewById(R.id.listMsjs);
        listamsj = new ArrayList<String>();
        txtConfirm=(TextView)findViewById(R.id.txtConfirm);
        btnConectar=(Button)findViewById(R.id.btnConnect);
        txtAviso=(TextView)findViewById(R.id.txtAviso);
        bSend=(Button)findViewById(R.id.bSend);
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread() {
                    public void run() {
                        try {
                            cliente = new Socket("192.168.1.53", 8080);
                            salida = new DataOutputStream(cliente.getOutputStream());
                            entrada = new DataInputStream(cliente.getInputStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
                TextView txt1=(TextView)findViewById(R.id.textView1);
                txt1.setVisibility(View.VISIBLE);
                etMessage.setVisibility(View.VISIBLE);
                bSend.setVisibility(View.VISIBLE);
                listMsjs.setVisibility(View.VISIBLE);
                txtAviso.setVisibility(View.VISIBLE);
                btnConectar.setVisibility(View.INVISIBLE);
            }
        });
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    salida.writeUTF(nombreP + " : " + etMessage.getText().toString());
                    salida.flush();
                    Reader readmsj = new Reader(entrada);
                    readmsj.start();
                    while (msjServer == null){
                        msjServer = readmsj.readMessage();
                    }
                    System.out.println(msjServer);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                listamsj.add(msjServer);
                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,listamsj);
                listMsjs.setAdapter(adapter);
                msjServer=null;
            }
        });
    }
}
