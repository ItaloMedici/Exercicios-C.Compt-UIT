package com.example.agendamentohorarios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnLogOut;
    private ImageButton btnCadastrarAtendimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        getSupportActionBar().hide();

        btnLogOut = (ImageButton) findViewById(R.id.logout);
        btnCadastrarAtendimento = (ImageButton) findViewById(R.id.btnAddAtendimento);

        btnLogOut.setOnClickListener(view -> logOut(view));
        btnCadastrarAtendimento.setOnClickListener(view -> cadastrarAtendimento(view));
    }

    public void logOut(View view) {
        Intent loginIntent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(loginIntent);
    }

    public void cadastrarAtendimento(View view) {
        Intent cadastroIntent =  new Intent(HomeActivity.this, CadastroAtendimentoAcitivity.class);
        startActivity(cadastroIntent);
    }
}
