package com.example.a1143878729.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private EditText et_nombre;
    private Button btn_ok;
    private ListView iv_estudiantes;
    private ArrayList<String> estudiantes;
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estudiantes = new ArrayList<>();
        //linkea el arraylist co el adapador
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estudiantes);

        et_nombre = findViewById(R.id.et_nombre);
        btn_ok = findViewById(R.id.btn_ok);
        iv_estudiantes = findViewById(R.id.iv_estudiantes);

        //linkea lo el arraylist y el adaptador con el listview
        iv_estudiantes.setAdapter(adaptador);

        View.OnClickListener miListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = et_nombre.getText().toString();
                estudiantes.add(nombre);
                adaptador.notifyDataSetChanged();
                et_nombre.setText("");
            }
        };

        btn_ok.setOnClickListener(miListener);
    }


}
