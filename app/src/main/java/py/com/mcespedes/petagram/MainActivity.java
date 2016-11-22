package py.com.mcespedes.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setTitle(null);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaDeMascotas();
        inicializarAdaptador();

    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaDeMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Animal 1", R.drawable.animal_1,0));
        mascotas.add(new Mascota("Animal 2", R.drawable.animal_2,0));
        mascotas.add(new Mascota("Animal 3", R.drawable.animal_3,0));
        mascotas.add(new Mascota("Animal 4", R.drawable.animal_4,0));
        mascotas.add(new Mascota("Animal 5", R.drawable.animal_5,0));
    }

    public void irfavoritos(View v){
        Intent i = new Intent(this,FavoritosMascota.class );
        startActivity(i);
    }
}