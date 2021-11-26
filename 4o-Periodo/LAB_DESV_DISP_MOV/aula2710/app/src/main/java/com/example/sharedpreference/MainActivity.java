package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvLogin;
    private TextView tvSenha;
    private Button btnLogin;
    private Button btnCancelar;
    private Button btnColor1;
    private Button btnColor2;
    private LinearLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLogin = (TextView) findViewById(R.id.editTextUsuario);
        tvSenha = (TextView) findViewById(R.id.editTextSenha);

        btnLogin= (Button) findViewById(R.id.buttonLogin);
        btnCancelar = (Button) findViewById(R.id.buttonCancelar);

        btnColor1 = (Button) findViewById(R.id.buttonColor1);
        btnColor2  = (Button) findViewById(R.id.buttonColor2);

        background = (LinearLayout) findViewById(R.id.background);

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

                int color = Preferences.getInteger(view.getContext(), "CorFundo");
                if (color == 1) {
                    background.setBackgroundResource(R.color.background1);
                } else if (color == 2) {
                    background.setBackgroundResource(R.color.background2);
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tvLogin.setText("");
                tvSenha.setText("");
                tvSenha.setBackgroundResource(R.color.purple_200);
            }
        });
    }

    private View.OnClickListener onClickColor1() {
        return new Button.OnClickListener() {
            public void onClick(View view) {
                background.setBackgroundResource(R.color.background1);
                Preferences.setInteger(view.getContext(), "CorFundo", 1);
            }
        };
    }

    private View.OnClickListener onClickColor2() {
        return new Button.OnClickListener() {
            public void onClick(View view) {
                background.setBackgroundResource(R.color.background2);
                Preferences.setInteger(view.getContext(), "CorFundo", 2);
            }
        };
    }

    private void alert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}