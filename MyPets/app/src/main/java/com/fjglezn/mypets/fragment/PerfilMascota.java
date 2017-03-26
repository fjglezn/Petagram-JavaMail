package com.fjglezn.mypets.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fjglezn.mypets.R;
import com.fjglezn.mypets.adapter.MascotaAdaptador;
import com.fjglezn.mypets.adapter.PerfilMascotaAdapter;
import com.fjglezn.mypets.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascota extends Fragment {

    //Variables
    ArrayList<Mascota> mascotas;

    private RecyclerView rvPerfilMascota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        rvPerfilMascota = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);

        //Creara la lista
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);//Define la orientación*/



        rvPerfilMascota.setLayoutManager(glm);//Se comporte con Linear Layout
        inicializarListaContacto();
        inicializaAdaptador();

        return v;
    }

    public void inicializarListaContacto()
    {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 1));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 0));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 1));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 0));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 2));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 0));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 5));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 0));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 2));

    }

    public void inicializaAdaptador()
    {
        PerfilMascotaAdapter adaptador = new PerfilMascotaAdapter(mascotas);
        rvPerfilMascota.setAdapter(adaptador);

    }
}
