package com.fjglezn.mypets.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjglezn.mypets.R;
import com.fjglezn.mypets.adapter.MascotaAdaptador;
import com.fjglezn.mypets.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReciclerViewFragment extends Fragment {

    //Variables
    ArrayList<Mascota> mascotas;

    private RecyclerView rvMascotas;
    public MascotaAdaptador adaptador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recicler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        //Creara la lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);//Define la orientación


        rvMascotas.setLayoutManager(llm);//Se comporte con Linear Layout
        inicializarListaContacto();
        inicializaAdaptador();

        return v;
    }

    public void inicializarListaContacto()
    {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota1, "Wally", 1));
        mascotas.add(new Mascota(R.drawable.mascota2, "Ronny", 0));
        mascotas.add(new Mascota(R.drawable.mascota3, "Pukky", 1));
        mascotas.add(new Mascota(R.drawable.mascota4, "Miky", 0));
        mascotas.add(new Mascota(R.drawable.mascota5, "Cuky", 2));
        mascotas.add(new Mascota(R.drawable.mascota6, "Crispi", 0));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 5));
        mascotas.add(new Mascota(R.drawable.mascota8, "Goddy", 0));
        mascotas.add(new Mascota(R.drawable.mascota9, "Gommy", 2));
        mascotas.add(new Mascota(R.drawable.mascota10, "Waki", 0));

    }

    public void inicializaAdaptador()
    {
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
        /*MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);*/
    }

}
