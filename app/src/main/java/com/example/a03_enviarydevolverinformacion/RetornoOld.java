package com.example.a03_enviarydevolverinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a03_enviarydevolverinformacion.modelos.Direccion;

public class RetornoOld extends AppCompatActivity {

    private EditText txtCalle;
    private EditText txtNumero;
    private EditText txtCiudad;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorno_old);
        inicializarVista();
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Direccion direccion = new Direccion();
                txtCalle.getText().toString();
                Integer.parseInt(txtNumero.getText().toString());
                txtCiudad.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putSerializable("DIR", direccion);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void inicializarVista() {
        txtCalle = findViewById(R.id.txtCalleOld);
        txtNumero = findViewById(R.id.txtNumeroOld);
        txtCiudad = findViewById(R.id.txtCiudadOld);
        btnCrear = findViewById(R.id.btnCrearOld);
    }
}