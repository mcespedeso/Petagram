package py.com.mcespedes.petagram.adaptador;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import py.com.mcespedes.petagram.db.ConstructorMascotas;
import py.com.mcespedes.petagram.pojo.Mascota;
import py.com.mcespedes.petagram.R;

/**
 * Created by root on 22/11/16.
 */

public class MascotaAdaptador extends  RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    //se define el array de mascotas
    ArrayList<Mascota> mascotas;
    //se define la actividad
    Activity activity;

    // Especifica un constructor
    //que recibe la lista de mascotas y
    //y la actividad que la instancia
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //inflar la vista y retornar el viewholder de la vista inflada
    //para obtener cada view
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImagen());
        mascotaViewHolder.tvNomnreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvPunto.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Hola!, mi nombre es "+mascota.getNombre(), Snackbar.LENGTH_LONG).show();

            }
        });

       mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLike(mascota);
                mascotaViewHolder.tvPunto.setText(String.valueOf(constructorMascotas.obtenerLikes(mascota)));

                //mascotaViewHolder.tvPunto.setText(String.valueOf(mascota.getLikes()+1));

                Snackbar.make(v, "Has agregado a "+mascota.getNombre()+" a favoritos", Snackbar.LENGTH_LONG)
                        .setAction(v.getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /*Intent i = new Intent(view.getContext(), FavoritosMascota.class );
                                view.getContext().startActivity(i);*/
                            }
                        })
                        .setActionTextColor(v.getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNomnreCV;
        private ImageButton btnLike;
        private TextView tvPunto;
        private ImageButton btLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNomnreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvPunto         = (TextView) itemView.findViewById(R.id.tvPunto);
            btLike          = (ImageButton)itemView.findViewById(R.id.btnLike);
        }

    }

}