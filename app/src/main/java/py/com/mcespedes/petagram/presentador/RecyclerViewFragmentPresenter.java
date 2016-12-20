package py.com.mcespedes.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import py.com.mcespedes.petagram.db.ConstructorMascotas;
import py.com.mcespedes.petagram.fragment.IReciclerViewfragmentView;
import py.com.mcespedes.petagram.pojo.Mascota;

/**
 * Created by root on 11/12/16.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IReciclerViewfragmentView iReciclerViewfragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> contactos;


    private ArrayList<Mascota> lista_contactos;

    public RecyclerViewFragmentPresenter(IReciclerViewfragmentView iReciclerViewfragmentView, Context context) {
        this.iReciclerViewfragmentView = iReciclerViewfragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
        //obtenerMediosRecientesByID();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas =  new ConstructorMascotas(context);
        contactos = constructorMascotas.ObtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iReciclerViewfragmentView.inicializarAdaptadorRV(iReciclerViewfragmentView.crearAdaptador(contactos));
        iReciclerViewfragmentView.generarLineaLayoutVertical();

    }


   /* @Override
    public void obtenerMediosRecientesByID() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse contactoResponse = response.body();
                lista_contactos = contactoResponse.getContactos();
                //mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context,"Fallo la conexion, intente de nuevo", Toast.LENGTH_LONG).show();
                //Log.i("Fallo la conexion",t.toString());
                t.printStackTrace();
            }

        });


    }*/

    @Override
    public void mostratContactosRV() {
        iReciclerViewfragmentView.inicializarAdaptadorRV(iReciclerViewfragmentView.crearAdaptador(contactos));
        iReciclerViewfragmentView.generarLineaLayoutVertical();
    }

}
