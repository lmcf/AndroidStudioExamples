package com.example.fragmentexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link itemfragment1.itemFragment1Listener} interface
 * to handle interaction events.
 * Use the {@link itemfragment1#newInstance} factory method to
 * create an instance of this fragment.
 */

public class itemfragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    TextView item1, item2, item3;


    private itemFragment1Listener mListener;

    public itemfragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment itemfragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static itemfragment1 newInstance(String param1, String param2, String param3) {
        itemfragment1 fragment = new itemfragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Hay que borrar el return de aquí y lo hacemos nosotros
        View view = inflater.inflate(R.layout.fragment_itemfragment1,container,false
        );

        // FindById no funcionara sin lo referencias con view
        item1 = view.findViewById(R.id.item1);
        item2 = view.findViewById(R.id.item2);
        item3 = view.findViewById(R.id.item3);

        // Si tuviera un boton un set on click listener y como siempre (no es el caso)

        // Metemos los datos en cada textview
        item1.setText(mParam1);
        item2.setText(mParam2);
        item3.setText(mParam3);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pulsadas;
                // Aqui utilizaremos el metodo contador pulsaciones que hemos implementado en el controller
                pulsadas = mListener.contador_pulsaciones();
                Log.i("CONTADOR", String.valueOf(pulsadas));
            }
        });

        // Finalmente devolvemos la view
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    // Los dos siguientes metodos no hay que tocarlos
    // Uno se encarga de que mListener tenga algo
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof itemFragment1Listener) {
            mListener = (itemFragment1Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    // Este oro libera el mListener (interface)
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    /*
     Muy importante este metodo para que le fragment funciones con el controller
     */
    public  interface itemFragment1Listener {
        // TODO: Update argument type and name
        int contador_pulsaciones();
    }


}
