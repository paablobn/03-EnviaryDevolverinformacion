package com.example.a03_enviarydevolverinformacion;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a03_enviarydevolverinformacion.modelos.Direccion;
import com.example.a03_enviarydevolverinformacion.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText txtPassword;
    private EditText txtEmail;
    private Button btnEnviar;
    private Button btnCrearDir;
    private Button btnCrearDirLauncher;

    private final int DIRECCIONES = 123;
    private final int COCHES = 8;

    private ActivityResultLauncher<Intent> crearDirLauncher;
    private ActivityResultLauncher<Intent> crearCocheLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        inicializaActivitiesResultLaunchers();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                Usuario usuario = new Usuario(email, password);
                Intent intent = new Intent(MainActivity.this, DescifrarPassActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("USUARIO", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnCrearDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, RetornoOld.class), DIRECCIONES);
            }
        });

        btnCrearDirLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RetornoOld.class);
                crearDirLauncher.launch(intent);
            }
        });
    }

    private void inicializaActivitiesResultLaunchers() {
        crearDirLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        Direccion dir = (Direccion) result.getData().getExtras().getSerializable("DIR");
                        Toast.makeText(MainActivity.this, dir.toString(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "CANCELADO", Toast.LENGTH_SHORT).show();
                }
            }
        });
        crearCocheLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                }
        );
    }

    private void inicializarVistas() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        btnEnviar = findViewById(R.id.btnEnviarContraseña);
        btnCrearDir = findViewById(R.id.btnCrearDirOldMain);
        btnCrearDirLauncher = findViewById(R.id.btnCrearDirLauncher);
    }

    /**
     * Se dispara al reactivar este Activity despues de lanzar una nueva Activity con startActivityForResult()
     *
     * @param requestCode -> constante que indica que Activity me esta retornando informacion
     * @param resultCode  -> codigo de resultado de como ha terminado la Actividad
     * @param data        -> intent que he puesto en el setResult()
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DIRECCIONES) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Direccion dir = (Direccion) data.getExtras().getSerializable("DIR");
                    Toast.makeText(this, dir.toString(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Entrada de Direccion Cancelada", Toast.LENGTH_SHORT).show();
            }
        }
    }
}