package com.example.agendamentohorarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.agendamentohorarios.usuario.DAOUsuario;
import com.example.agendamentohorarios.usuario.Usuario;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnLogin;
    private EditText emailEt;
    private EditText senhaEt;

    String[] erros = {
            "Preencha todos os campos corretamente",
            "Email/Senha incorreta",
            "Erro ao pesquisar ID"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getSupportActionBar().hide();

        initComponents();

        btnLogin.setOnClickListener(this::login);
    }

    private void initComponents() {
        btnLogin = (MaterialButton) findViewById(R.id.btnLogin);
        emailEt = (EditText) findViewById(R.id.edit_email);
        senhaEt = (EditText) findViewById(R.id.edit_senha);
    }

    public void login(View view) {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        DAOUsuario db = new DAOUsuario(this);

        inserirUsuarioTeste(db);

        Usuario usuario =  new Usuario();
        String email = emailEt.getText().toString();
        String senha = senhaEt.getText().toString();

        if (email.isEmpty() || senha.isEmpty()) {
            Snackbar snackbar = Snackbar.make(view, erros[0], Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();

        } else {
            usuario.setEmail(email);
            usuario.setSenha(senha);

            if(db.authLogin(usuario)) {
                Long id = db.getIDByEmail(email);
                if (id != null) {
                    homeIntent.putExtra("idUsuario", id);
                    startActivity(homeIntent);
                } else {
                    Snackbar snackbar = Snackbar.make(view, erros[2], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            } else {
                Snackbar snackbar = Snackbar.make(view, erros[1], Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();
            }
        }
    }

    private void inserirUsuarioTeste(DAOUsuario db) {
        db.insert(new Usuario("Italo", "admin", "123"));
    }
}