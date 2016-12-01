package py.com.mcespedes.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import py.com.mcespedes.petagram.R;
import py.com.mcespedes.petagram.adaptador.PerfilMascotaAdapter;
import py.com.mcespedes.petagram.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas= new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        // Imagen circukar
        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.imagCircular);
        // Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorIcons));
        circularImageView.setBorderWidth(10);
        // Add Shadow with default param
        circularImageView.addShadow();
        // or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(getResources().getColor(R.color.colorPrimaryDark));

        //creando reciclerview
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);
        //  LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //  llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaMascotas.setLayoutManager(glm);


        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();


        return v;

    }

    //carga 5 elementos en el recyclerview
    public void inicializarListaMascotas(){

        mascotas.add(new Mascota("animal_2", R.drawable.animal_2, 3));
        mascotas.add(new Mascota("animal_5", R.drawable.animal_5,2));
        mascotas.add(new Mascota("animal_2", R.drawable.animal_2,6));
        mascotas.add(new Mascota("animal_5", R.drawable.animal_5,1));
        mascotas.add(new Mascota("animal_4", R.drawable.animal_4,3));
        mascotas.add(new Mascota("animal_2", R.drawable.animal_2, 3));
        mascotas.add(new Mascota("animal_5", R.drawable.animal_5,2));
        mascotas.add(new Mascota("animal_2", R.drawable.animal_2,6));
        mascotas.add(new Mascota("animal_5", R.drawable.animal_5,1));
        mascotas.add(new Mascota("animal_4", R.drawable.animal_4,3));

    }

    public void inicializarAdaptador(){
        PerfilMascotaAdapter adaptador = new PerfilMascotaAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

}
