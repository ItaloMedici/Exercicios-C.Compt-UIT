package com.example.agendamentohorarios;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agendamentohorarios.atendimento.Atendimento;
import com.example.agendamentohorarios.atendimento.DAOAtendimento;
import com.example.agendamentohorarios.usuario.Usuario;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroAtendimentoAcitivity extends AppCompatActivity {

    private MaterialButton btnSave;
    private EditText etNomeCLiente;
    private EditText etDescricao;
    private EditText etValor;
    private EditText etObservacao;
    private EditText etAgendamento;

    private static Usuario usuario = new Usuario();

    String[] erros = {
            "Preencha todos os campos corretamente",
            "Data inválida",
            "Não é possivel inserir data anterior ao dia de hoje!",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_atendimento);
        getSupportActionBar().hide();
        initCompoenents();

        btnSave.setOnClickListener(view -> salvar(view));
    }

    private void initCompoenents() {
        btnSave = (MaterialButton) findViewById(R.id.btnSave);
        etNomeCLiente = (EditText) findViewById(R.id.nomeText);
        etDescricao = (EditText) findViewById(R.id.descricaoServico);
        etValor = (EditText) findViewById(R.id.valorServico);
        etObservacao = (EditText) findViewById(R.id.obervacao);
        etAgendamento = (EditText) findViewById(R.id.diaText);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();

            if (extras != null) {
                usuario.setIdentificador(extras.getLong("idUsuario"));
                usuario.setNome(extras.getString("email"));
            }
        }
    }


    public void salvar(View view) {
        Intent homeIntent = new Intent(CadastroAtendimentoAcitivity.this, HomeActivity.class);
        DAOAtendimento daoAtendimento = new DAOAtendimento(this);

        String nomeCLiente = etNomeCLiente.getText().toString();
        String descricao = etDescricao.getText().toString();
        String valorStr = etValor.getText().toString();
        String observacao = etObservacao.getText().toString();
        String horarioStr = etAgendamento.getText().toString();

        Date horario = new Date();
        Double valor = 0d;

        if (nomeCLiente.isEmpty()
                || descricao.isEmpty()
                || valorStr.isEmpty()
                || horarioStr.isEmpty()
        ) {
            Snackbar snackbar = Snackbar.make(view, erros[0], Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        } else {
            valor = Double.parseDouble(valorStr);

            try {
                horario = new SimpleDateFormat("dd/MM/yyyy HH:MM").parse(horarioStr);
            } catch (ParseException e) {
                Snackbar snackbar = Snackbar.make(view, erros[1], Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();
            }

            if (horario.before(new Date())) {
                Snackbar snackbar = Snackbar.make(view, erros[2], Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();
            } else {
                Atendimento atendimento = new Atendimento(descricao, valor, horario, observacao, nomeCLiente, usuario);
                daoAtendimento.insert(atendimento);

                Snackbar snackbar = Snackbar.make(view, "Agendado com sucesso!", Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.GRAY);
                snackbar.setTextColor(Color.WHITE);
                snackbar.show();

                startActivity(homeIntent);
            }
        }
    }
}
