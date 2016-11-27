package com.example.juand.graphmsgv10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import java.util.Arrays;

/**
 * Ventana de iniciar seción en Facebook, se inicia la aplicacion con esta.
 * Autor: Juan D. Esquivel.
 */
public class LoginActivity extends AppCompatActivity {
    static LoginButton LoginBtn;
    private CallbackManager callbackManager;
    String nomPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        callbackManager=CallbackManager.Factory.create();
        LoginBtn=(LoginButton)findViewById(R.id.loginButton);
        LoginBtn.setReadPermissions(Arrays.asList("email","public_profile"));//pide como información el email para que inicie seción.
        LoginBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            /**
             * Metodo si se inicia la sesión.
             * Si se cumple, nos redirecciona a la ventana principal de la aplicacion.
             * Autor: Juan D. Esquivel.
             */
            @Override
            public void onSuccess(LoginResult loginResult) { //El inicio de sesión es correcto
                //Metodo que toma como parametro el ID del usuario ingresado y muestra su foto de perfil.
                ProfilePictureView profilePicture = (ProfilePictureView)findViewById(R.id.profilePicture);
                profilePicture.setCropped(true);
                profilePicture.setProfileId(loginResult.getAccessToken().getUserId().toString());

                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                nombrePerfil(profile);
                AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
                    @Override
                    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

                    }
                };
                ProfileTracker profileTracker = new ProfileTracker(){
                    @Override
                    protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                        nombrePerfil(currentProfile);
                    }
                };
                accessTokenTracker.startTracking();
                profileTracker.startTracking();
                LoginBtn.setReadPermissions(Arrays.asList("public_profile"));

                Button confirmarBtn = (Button) findViewById(R.id.ConfirmBtn);
                confirmarBtn.setVisibility(View.VISIBLE);
                TextView text2 = (TextView)findViewById(R.id.textView2);
                text2.setVisibility(View.VISIBLE);
            }

            /**
             * Si se cancela el inicio de sesión con Facebook.
             * Si se cumple, nos indica con un mensaje flotante que el inicio de secion se cancelo.
             * Autor: Juan D. Esquivel.
             */
            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Has cancelado el inicio de sesión con FaceBook", Toast.LENGTH_LONG).show();
            }
            /**
             * Si se produce un error en el inicio de sesión con Facebook.
             * Si se cumple, nos indica con un mensaje flotante que el inicio de secion tuvo algun error.
             * Autor: Juan D. Esquivel.
             */
            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Ha ocurrido un error iniciando seción, intentelo de nuevo.", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Metodo para ir a la ventana principal, se usa si se ha iniciado la sesión.
     * Autor: Juan D. Esquivel.
     */
    public void confirmar(View view) {
        irMainActivity();
    }
    private void irMainActivity() {
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra("nombrePerfil",nomPerfil);
        startActivity(intent1);
    }

    /**
     * Metodo que obtiene el nombre del usuario que ingresa al facebook mediante los permisos.
     * Imprime el  nombre del usuario en pantalla.
     * @param perfil
     * Autor Juan D. Esquivel.
     */
    private void nombrePerfil(Profile perfil){
        if (perfil!=null){
            nomPerfil =perfil.getName();
            TextView txtNombre = (TextView)findViewById(R.id.txtNombre);
            txtNombre.setText(nomPerfil);
            txtNombre.setVisibility(View.VISIBLE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
