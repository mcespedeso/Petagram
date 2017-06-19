package py.com.mcespedes.petagram.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import py.com.mcespedes.petagram.R;
import py.com.mcespedes.petagram.RestApi.ConstantesRestApi;
import py.com.mcespedes.petagram.RestApi.EndpointsApi;
import py.com.mcespedes.petagram.RestApi.adapter.RestApiAdapter;
import py.com.mcespedes.petagram.RestApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuardarUsuarioInstagramActivity extends AppCompatActivity {

    private static final String TAG = "TOKEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_usuario_instagram);
    }

    public void obtenerId(View view) {

        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);

    }

    public void enviarTokenRegistro(String token){

        //Log.d(TAG, token);

        RestApiAdapter restApiAdapter = new RestApiAdapter();

        EndpointsApi endpoints = restApiAdapter.establecerConexionRestApiToken();

        Call<UsuarioResponse> usuarioResponseCall = endpoints.registrarTokenID(token);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE    " , usuarioResponse.getId());
                Log.d("TOKEN_FIREBASE " , usuarioResponse.getToken());
                setTokenInShared(usuarioResponse.getToken());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.d("ERROR " , t.getMessage().toString());
            }
        });

    }

    public void setTokenInShared(String token_device){
        //Log.d(TAG, token_device);
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token_device",token_device);
        //Log.d(TAG, "registro el token en el shared");
        editor.apply();
    }

    public void guardarInstagram(View view) {

        RestApiAdapter restApiAdapter = new RestApiAdapter();

        EndpointsApi endpoints = restApiAdapter.establecerConexionRestApiToken();

        String token_device = FirebaseInstanceId.getInstance().getToken();

        Call<String> usuarioResponseCall = endpoints.registrarUsuarioInstagram(token_device, ConstantesRestApi.KEY_INSTAGRAM_ID);

        usuarioResponseCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                int res = response.code();
                System.out.println("el codigo de la resp. es: " + res);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("ERROR " , t.getMessage().toString());
            }
        });

    }

    public void enviarNotificacion(View view) {

        Log.d("TOQUE_ANIMAL", "true");
        //final UsuarioResponse usuarioResponse = new UsuarioResponse(ID_RECEPTOR, "123", ANIMAL_RECEPTOR);
        RestApiAdapter restApiAdapter =  new RestApiAdapter();
        EndpointsApi endponits = restApiAdapter.establecerConexionRestApiToken();
        Call<UsuarioResponse> usuarioResponseCall = endponits.toqueAnimal("-Kn0kL3htnkB37p8frmo", "Cacho");
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {

                int res = response.code();
                System.out.println("el codigo de la resp. es: " + res);

            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Error al enviar notificacion", Toast.LENGTH_LONG).show();
            }
        });


    }
}
