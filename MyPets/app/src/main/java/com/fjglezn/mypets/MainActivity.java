package com.fjglezn.mypets;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.fjglezn.mypets.adapter.MascotaAdaptador;
import com.fjglezn.mypets.adapter.PageAdapter;
import com.fjglezn.mypets.fragment.PerfilMascota;
import com.fjglezn.mypets.fragment.ReciclerViewFragment;
import com.fjglezn.mypets.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setUpViewPager();//Se llama al metodo


    }//onCreate

    //Menú de opciones que se muestra en el actionbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Tomara el menu y lo mostrara en la vista
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    //Menú de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mAcerca:
            {
                Intent intent = new Intent(this, AcercaDeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.mContacto:
            {
                Intent intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.mStar:
            {
                Intent  intent = new Intent(this, MascotasFavoritas.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Fragment> agregarFragments()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();

        //La lista de los fragments que se crearon
        fragments.add(new ReciclerViewFragment());
        fragments.add(new PerfilMascota());

        return fragments;
    }

    //Metodo que pondra en orbita los fragments
    public void setUpViewPager()
    {
        //Se pasa la lista que se agregaran al viewPager
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        //se agrega al tab

        tabLayout.setupWithViewPager(viewPager);

        //Iconos de los tab
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);

    }


  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mStar)
        {
                Intent  intent = new Intent(this, MascotasFavoritas.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }*/


}
