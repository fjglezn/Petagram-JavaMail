package com.fjglezn.mypets.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fjglezn.mypets.R;
import com.fjglezn.mypets.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fjglezn on 16/01/2017.
 */
public class PerfilMascotaAdapter extends RecyclerView.Adapter<PerfilMascotaAdapter.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;

    public PerfilMascotaAdapter(ArrayList<Mascota> mascotas)
    {
        this.mascotas = mascotas;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvRaitingCV.setText(""+mascota.getRaiting());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //Variables
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRaitingCV;
        private ImageView btnLike;


        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV   = (TextView) itemView.findViewById(R.id.tvRaitingCV);
            btnLike     = (ImageView) itemView.findViewById(R.id.btnLike);
        }
    }


}