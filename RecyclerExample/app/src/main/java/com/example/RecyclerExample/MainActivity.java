package com.example.RecyclerExample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   RecyclerView recyclerView;
   List<infoRecycler> lista;
   RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();

        // Recycler
        recyclerView = findViewById(R.id.recyclerRes);

        infoRecycler p1 = new infoRecycler("Item1");
        infoRecycler p2 = new infoRecycler("Item2");
        infoRecycler p3 = new infoRecycler("Item3");
        infoRecycler p4 = new infoRecycler("Item4");
        infoRecycler p5 = new infoRecycler("Item5");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);

        // Mostrar Recycler
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);


    }

    // El Adapter se encarga de enlazar el ViewHolder con el listado de datos, los prepara para pintarlos
    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>{

        public RecyclerAdapter() {

        }

        @Override
        // Dibuja en pantalla los viewholder (elementos de la lista)
        public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = getLayoutInflater();

            return new RecyclerHolder(layoutInflater, viewGroup);
        }

        @Override
        // Pones los datos en cada viewholder
        public void onBindViewHolder(@NonNull RecyclerHolder recyclerHolder , int i) {

            infoRecycler res = lista.get(i);
            recyclerHolder.nombre.setText(res.getNombre());
        }

        // Metodo que devuelve la cantidad de objectos de la array.
        // Y sabremos cuantas veces recorrera el bucle que pinta los datos
        @Override
        public int getItemCount() {
            return lista.size();
        }


        /* MusicaHolder es el bloque donde pinto la info de cada objeto de cojo de la array */
        class RecyclerHolder extends RecyclerView.ViewHolder{
            TextView nombre;

            public RecyclerHolder(LayoutInflater layoutInflater, ViewGroup parent) { // Busca el itemview
                super(layoutInflater.inflate(R.layout.recyclerholder, parent,false));

                nombre = itemView.findViewById(R.id.nombre);
            }
        }

    }
}
