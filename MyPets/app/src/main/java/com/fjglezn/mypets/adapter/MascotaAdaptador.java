package com.fjglezn.mypets.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fjglezn.mypets.R;
import com.fjglezn.mypets.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fjglezn on 06/01/2017.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;


    public  MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {


        final Mascota mascota = mascotas.get(position);//Se invoca cada vez que se va recorriendo la lista de contactos.

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRaiting.setText(""+mascota.getRaiting());


        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {

            int raiting = mascota.getRaiting();

            @Override
            public void onClick(View v) {

                raiting++;

                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                mascotaViewHolder.tvRaiting.setText(""+(raiting));

                mascota.setRaiting(raiting);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //Variables
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRaiting;
        private ImageView btnLike;


        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaiting   = (TextView) itemView.findViewById(R.id.tvRaiting);
            btnLike     = (ImageView) itemView.findViewById(R.id.btnLike);
        }
    }



}
