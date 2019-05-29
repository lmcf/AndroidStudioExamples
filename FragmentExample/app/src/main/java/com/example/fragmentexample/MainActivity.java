package com.example.fragmentexample;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// Has de implementas el itemfragment
public class MainActivity extends AppCompatActivity implements itemfragment1.itemFragment1Listener{
    // Del metodo
    int pulsaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pulsaciones = 0;

        // Esto sirve para dibujar los fragments
        FragmentManager fm = getSupportFragmentManager();

        // newInstance para poderle pasar los argumentos a itemfragment1
        Fragment fragment = new itemfragment1().newInstance("parametro1","parametro2","parametro3");

        //El contenedor del fragment
        fm.beginTransaction().replace(R.id.fragment_container1,fragment).commit();
    }


    // Ejemplo del metodo que tendo en itemreservafragmente.
    public int contador_pulsaciones() {
        pulsaciones ++;
        return pulsaciones;
    }


}
