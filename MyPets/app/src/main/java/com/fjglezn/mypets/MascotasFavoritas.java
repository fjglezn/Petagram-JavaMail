package com.fjglezn.mypets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.fjglezn.mypets.adapter.MascotaAdaptador;
import com.fjglezn.mypets.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    private RecyclerView rvMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);


        //Creara la lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);//Define la orientación


        rvMascotas.setLayoutManager(llm);//Se comporte con Linear Layout
        inicializarListaContacto();
        inicializaAdaptador();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    public void inicializarListaContacto(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota1, "Wally", 1));
        mascotas.add(new Mascota(R.drawable.mascota3, "Pukky", 1));
        mascotas.add(new Mascota(R.drawable.mascota5, "Cuky", 2));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 5));
        mascotas.add(new Mascota(R.drawable.mascota9, "Gommy", 2));

    }

    public void inicializaAdaptador() {

        adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
        /*MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);*/
    }


}