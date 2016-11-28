package com.example.juand.graphmsgv10;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import java.util.Set;

import static android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE;


/**
 * Ventana principal de la aplicacion.
 * Para acceder a ella se debe haber iniciado sesión en facebook.
 * Autor: Juan D. Esquivel
 */
public class MainActivity extends AppCompatActivity {
    Button btnBuscar;
    BluetoothAdapter btAdapter;
    int REQUEST_CODE = 1;
    Set<BluetoothDevice> conectDevices;
    String listDevices[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (AccessToken.getCurrentAccessToken() == null) {
            irLoginActivity();
        }
        btnBuscar=(Button)findViewById(R.id.btnBluetooth);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btAdapter = BluetoothAdapter.getDefaultAdapter();
                if(btAdapter==null){
                    Toast.makeText(getBaseContext(),"Lo sentimos, no se encontró ningún dispositivo activo",Toast.LENGTH_LONG).show();
                }else{
                    if(!btAdapter.isEnabled()){
                        Intent intent1=new Intent(ACTION_REQUEST_ENABLE);
                        startActivityForResult(intent1,REQUEST_CODE);

                    }
                }
            }
        });
    }
    /**
     * Método que llama a la pagina para iniciar seción con FB.
     * Se usa si el usuario no esta logeado.
     * Autor: Juan D. Esquivel.
     */
    private void irLoginActivity() {
        Intent intent2 = new Intent(this, LoginActivity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
    }
    /**
     * Metodo para cerrar seción de Facebook, lo utiliza el boton de cerrar seción.
     * @param view
     * Autor: Juan D. Esquivel.
     */
    public void cerrarSesion(View view) {
        LoginManager.getInstance().logOut();
        irLoginActivity();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onActivityResult(int requestcode,int resultcode,Intent data){
        if(requestcode==REQUEST_CODE){
            if(resultcode==RESULT_OK){
                Toast.makeText(getBaseContext(),"Bluetooth iniciado con éxito!",Toast.LENGTH_LONG).show();
                conectDevices=btAdapter.getBondedDevices(); // poner en una lista los dispositivos emparejados.
                int i = conectDevices.size();
                listDevices = new String[i];
                int j = 0;
                for(BluetoothDevice device : conectDevices){
                    listDevices[j]=device.getName()+"\n"+device.getAddress();
                    j++;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("list_devices",listDevices);
                Intent intent2 = new Intent(MainActivity.this,ListActivity.class);
                intent2.putExtras(bundle);
                String nombre = getIntent().getExtras().getString("nombrePerfil");
                intent2.putExtra("nombrePer", nombre);
                startActivity(intent2);
            }else{
                Toast.makeText(getBaseContext(),"Fallo el incio del Bluetooth. Intentelo de nuevo.",Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
