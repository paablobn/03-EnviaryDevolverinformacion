package com.example.a03_enviarydevolverinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.a03_enviarydevolverinformacion.modelos.Usuario;

public class DescifrarPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descifrar_pass);

        Intent intentCreacion = getIntent();
        Bundle bundle = intentCreacion.getExtras();
        Usuario user = (Usuario) bundle.getSerializable("USUARIO");
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
    }
}