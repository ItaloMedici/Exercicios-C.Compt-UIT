package com.example.agendamentohorarios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class CadastroAtendimentoAcitivity extends AppCompatActivity {

    private MaterialButton btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_atendimento);
        getSupportActionBar().hide();

        btnSave = (MaterialButton) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view -> salvar(view));
    }

    public void salvar(View view) {
        Intent homeIntent = new Intent(CadastroAtendimentoAcitivity.this, HomeActivity.class);
        startActivity(homeIntent);
    }
}
