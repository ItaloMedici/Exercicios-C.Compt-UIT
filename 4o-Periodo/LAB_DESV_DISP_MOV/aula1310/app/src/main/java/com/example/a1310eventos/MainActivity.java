package com.example.a1310eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvLogin;
    TextView tvSenha;
    Button btnLogin;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLogin = (TextView) findViewById(R.id.editTextUsuario);
        tvSenha = (TextView) findViewById(R.id.editTextSenha);

        btnLogin= (Button) findViewById(R.id.buttonLogin);
        btnCancelar = (Button) findViewById(R.id.buttonCancelar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = tvLogin.getText().toString();
                String senha = tvSenha.getText().toString();

                if (login.equalsIgnoreCase("uit") && senha.equalsIgnoreCase("123")) {
                    alert("Bem vindo!");
                } else {
                    alert("Usuario/senha inválidas");
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvLogin.setText("");
                tvSenha.setText("");
                tvSenha.setBackgroundResource(R.color.purple_200);
            }
        });
    }

    private void alert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}