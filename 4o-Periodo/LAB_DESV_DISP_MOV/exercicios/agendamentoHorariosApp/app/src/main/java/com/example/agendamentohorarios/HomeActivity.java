package com.example.agendamentohorarios;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendamentohorarios.atendimento.Atendimento;
import com.example.agendamentohorarios.atendimento.AtendimentoAdapter;
import com.example.agendamentohorarios.atendimento.DAOAtendimento;
import com.example.agendamentohorarios.usuario.DAOUsuario;
import com.example.agendamentohorarios.usuario.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnLogOut;
    private ImageButton btnCadastrarAtendimento;
    private static Usuario usuario = new Usuario();
    ListView cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initComponents();
        getSupportActionBar().hide();

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();

            if (extras != null) {
                usuario.setIdentificador(extras.getLong("idUsuario"));
                usuario.setNome(extras.getString("email"));
                usuario.setEmail(extras.getString("senha"));
            }
        }

        DAOAtendimento daoAtendimento = new DAOAtendimento(this);
        //inserirAtendimentosTeste(daoAtendimento);

        List<Atendimento> atendimentos = daoAtendimento.searchByIdUsuario(usuario);

        AtendimentoAdapter adapter = new AtendimentoAdapter(getApplicationContext(), atendimentos);

        cardList.setAdapter(adapter);

        btnLogOut.setOnClickListener(this::logOut);
        btnCadastrarAtendimento.setOnClickListener(this::cadastrarAtendimento);
    }

    private void initComponents() {
        btnLogOut = (ImageButton) findViewById(R.id.logout);
        btnCadastrarAtendimento = (ImageButton) findViewById(R.id.btnAddAtendimento);
        cardList = (ListView) findViewById(R.id.card_list);

    }

    public void logOut(View view) {
        Intent loginIntent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(loginIntent);
    }

    public void cadastrarAtendimento(View view) {
        Intent cadastroIntent =  new Intent(HomeActivity.this, CadastroAtendimentoAcitivity.class);

        cadastroIntent.putExtra("idUsuario", usuario.getIdentificador());
        cadastroIntent.putExtra("email", usuario.getEmail());

        startActivity(cadastroIntent);
    }

    private void inserirAtendimentosTeste(DAOAtendimento db) {
        Atendimento atd = new Atendimento("Limpeza", 120d, new Date(), "Obs", "Italo", usuario);
        Atendimento atd2 = new Atendimento("Pele", 140d, new Date(), "Obs", "Italo", usuario);

        db.insert(atd);
        db.insert(atd2);
    }
}
