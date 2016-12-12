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

    public RecyclerViewFragmentPresenter(IReciclerViewfragmentView iReciclerViewfragmentView, Context context) {
        this.iReciclerViewfragmentView = iReciclerViewfragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
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

}
