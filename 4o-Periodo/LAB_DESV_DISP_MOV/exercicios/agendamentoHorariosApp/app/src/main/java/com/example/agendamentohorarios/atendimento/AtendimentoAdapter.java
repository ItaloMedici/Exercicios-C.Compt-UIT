package com.example.agendamentohorarios.atendimento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.agendamentohorarios.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class AtendimentoAdapter extends ArrayAdapter<Atendimento> {

    private Context context;
    private List<Atendimento> atendimentos;

    public AtendimentoAdapter(Context context, int resource, List<Atendimento> atendimentos) {
        super(context,resource);
        this.context = context;
        this.atendimentos = atendimentos;
    }

    @Override
    public int getCount() {
        return atendimentos.size();
    }

    @Override
    public Atendimento getItem(int i) {
        return atendimentos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return atendimentos.get(i).getIdentificador();
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        final int indexAux = index;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) layoutInflater.inflate(R.layout.card, null);

        TextView nomeCli = (TextView) layout.findViewById(R.id.nomeCliente);
        TextView hora = (TextView) layout.findViewById(R.id.hora);
        TextView descricao = (TextView) layout.findViewById(R.id.descricao);
        TextView valor = (TextView) layout.findViewById(R.id.valor);
        ConstraintLayout card = (ConstraintLayout) layout.findViewById(R.id.card);

        Atendimento atendimento = atendimentos.get(indexAux);

        nomeCli.setText(atendimento.getNomeCliente());
        hora.setText(new SimpleDateFormat("HH:MM").format(atendimento.getHorario()));
        descricao.setText(atendimento.getDescricao());
        valor.setText(new DecimalFormat("¤ #,##0.00;").format(atendimento.getNomeCliente()));

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return layout;
    }
}
