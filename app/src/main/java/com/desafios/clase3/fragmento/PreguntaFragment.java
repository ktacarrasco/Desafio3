package com.desafios.clase3.fragmento;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.desafios.clase3.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreguntaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class PreguntaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    int radioButtonValue = 0;

    private RadioGroup grupoRespuestasView;
    private RadioButton respuestaUno, respuestaDos;
    private TextView pregunta ,categoria,dificultad;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private Button button;

    public PreguntaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PreguntaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreguntaFragment newInstance(String param1, String param2, String param3) {
        PreguntaFragment fragment = new PreguntaFragment();
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
        View view = inflater.inflate(R.layout.fragment_pregunta, container, false);
        initializeViews(view);
        pregunta.setText(mParam1);
        categoria.setText(mParam2);
        dificultad.setText(mParam3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWithWhatsApp(v);

            }
        });
        return view;
    }

    private void initializeViews(View view){
        pregunta= view.findViewById(R.id.pregunta);
        categoria = view.findViewById(R.id.categoria);
        dificultad = view.findViewById(R.id.Dificultad);
        button = view.findViewById(R.id.btn);

    }

    private void pasarAlotrofragmento(){
        SegundoFragment segundofragmento = SegundoFragment.newInstance("","");
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl1,segundofragmento,"SECONDFRAGMENT")
                .addToBackStack("SECONDFRAGMENT").commit();

    }

    public void shareWithWhatsApp(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "¡Hola! te comparto mi niota obtenida hoy: " +
                pregunta.getText().toString());
        sendIntent.setType("text/plain");
        //sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }

}
