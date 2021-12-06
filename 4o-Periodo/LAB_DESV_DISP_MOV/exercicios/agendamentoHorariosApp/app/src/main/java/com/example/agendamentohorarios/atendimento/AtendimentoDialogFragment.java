package com.example.agendamentohorarios.atendimento;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agendamentohorarios.R;


public class AtendimentoDialogFragment extends DialogFragment {

    private TextView observacao;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_atendimento, null);
        initComponents(layout);


        builder.setView(layout);
        return builder.create();
    }

    private void initComponents(View view) {
        observacao = (TextView) view.findViewById(R.id.nomeText);
    }
}
