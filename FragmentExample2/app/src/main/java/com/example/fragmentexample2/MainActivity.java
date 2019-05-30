package com.example.fragmentexample2;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// Has de implementas el itemfragment
public class MainActivity extends AppCompatActivity implements
        itemfragment1.onFragmentInteraction, FragmentBienvenida.OnFragmentInteractionListener{

    FragmentBienvenida bienvenido;
    itemfragment1 pantalla1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociamos variables a fragments
        bienvenido = new FragmentBienvenida();
        pantalla1 = new itemfragment1().newInstance("Parametro nº 1","Parametro nº 2", "Parametro nº 3");

        //Para mostrar 1 frament nada mas empezar, hacemos esto, NO OLVIDAR COMMIT()
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,bienvenido).commit();

    }


    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction fmt = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()){
            case R.id.fragment1:
                fmt.replace(R.id.fragment_container,pantalla1);
                break;

        }

        fmt.commit();

        return super.onOptionsItemSelected(item);
    }


    // Cunaod no usamos metodos del controller sin nada
    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
