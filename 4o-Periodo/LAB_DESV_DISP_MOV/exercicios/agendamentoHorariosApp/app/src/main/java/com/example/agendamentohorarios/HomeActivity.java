package com.example.agendamentohorarios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendamentohorarios.atendimento.Atendimento;
import com.example.agendamentohorarios.atendimento.AtendimentoAdapter;
import com.example.agendamentohorarios.atendimento.DAOAtendimento;
import com.example.agendamentohorarios.usuario.DAOUsuario;
import com.example.agendamentohorarios.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnLogOut;
    private ImageButton btnCadastrarAtendimento;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initComponents();
        getSupportActionBar().hide();

        Intent intent = new Intent();
        String id = intent.getStringExtra("id");

        DAOUsuario daoUsuario = new DAOUsuario(this);
        DAOAtendimento daoAtendimento = new DAOAtendimento(this);

        usuario = daoUsuario.getUsuarioByID(Long.valueOf(id));
        List<Atendimento> atendimentos = daoAtendimento.searchByIdUsuario(usuario);

        AtendimentoAdapter adapter = new AtendimentoAdapter(getApplicationContext(), R.id.card_list, atendimentos);

        btnLogOut.setOnClickListener(this::logOut);
        btnCadastrarAtendimento.setOnClickListener(this::cadastrarAtendimento);
    }

    private void initComponents() {
        btnLogOut = (ImageButton) findViewById(R.id.logout);
        btnCadastrarAtendimento = (ImageButton) findViewById(R.id.btnAddAtendimento);

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
