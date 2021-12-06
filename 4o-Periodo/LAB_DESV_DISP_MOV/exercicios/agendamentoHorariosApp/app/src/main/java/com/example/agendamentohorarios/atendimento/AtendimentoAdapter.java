package com.example.agendamentohorarios.atendimento;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.example.agendamentohorarios.R;
import com.example.agendamentohorarios.ToolDate;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AtendimentoAdapter extends BaseAdapter {

    private Context context;
    private List<Atendimento> atendimentos;
    private Date dateAux = new Date(2020, 1, 1);

    public AtendimentoAdapter(Context context, List<Atendimento> atendimentos) {
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
        TextView dataTitulo = (TextView) layout.findViewById(R.id.dataTitulo);
        TextView valor = (TextView) layout.findViewById(R.id.valor);
        LinearLayout card = (LinearLayout) layout.findViewById(R.id.card);

        Atendimento atendimento = atendimentos.get(indexAux);

        String dataStr = ToolDate.dateToStr(atendimento.getHorario(), ToolDate.DATA);
        String dataStrAux = ToolDate.dateToStr(dateAux, ToolDate.DATA);

        if (!dataStr.equals(dataStrAux)) {
            dateAux = atendimento.getHorario();
            dataTitulo.setVisibility(View.VISIBLE);
        } else {
            dataTitulo.setVisibility(View.GONE);
        }

        nomeCli.setText(atendimento.getNomeCliente());

        String s = ToolDate.dateToStr(atendimento.getHorario(), ToolDate.HORA);

        hora.setText(s);
        descricao.setText(atendimento.getDescricao());
        valor.setText(new DecimalFormat("¤ #,##0.00;").format(atendimento.getValor()));
        dataTitulo.setText(dataStr);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AtendimentoDialogFragment atdDialog = new AtendimentoDialogFragment();
                //atdDialog.show(atdDialog.getFragmentManager(), "atendimento");
            }
        });

        return layout;
    }
}
