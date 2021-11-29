package com.example.agendamentohorarios.atendimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.agendamentohorarios.DBUtils;
import com.example.agendamentohorarios.usuario.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOAtendimento extends DBUtils {

    private static final String table = "atendimento";
    private static final String[] colunas = {
            "_id_atendimento",
            "descricao",
            "valor",
            "horario",
            "observacao",
            "nome_cliente",
            "_id_usuario"
    };

    public DAOAtendimento(Context context) {
        super(context);
    }

    @Override
    public void insert(Object o) {
        Atendimento atd = (Atendimento) o;

        ContentValues values = new ContentValues();
        values.put(colunas[1], atd.getDescricao());
        values.put(colunas[2], atd.getValor());
        values.put(colunas[3], new SimpleDateFormat("dd/MM/yyyy HH:MM").format(atd.getHorario()));
        values.put(colunas[4], atd.getObservacao());
        values.put(colunas[5], atd.getUsuario().getIdentificador());


        database.insert(table, null, values);
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public List<?> search() {
        return null;
    }

    public List<Atendimento> searchByIdUsuario(Usuario u) {
        List<Atendimento> atendimentos = new ArrayList<>();

        String whereClause = colunas[7] + " = ? ";
        String[] whereArgs = new String[] {
                u.getEmail()
        };

        Cursor c = database.query(
                table, colunas,
                whereClause, whereArgs,
                null, null, colunas[3] + "DESC"
        );

        while (c.moveToNext()) {
            Long id = c.getLong(c.getColumnIndexOrThrow(colunas[0]));
            String descricao = c.getString(c.getColumnIndexOrThrow(colunas[1]));
            Double valor = c.getDouble(c.getColumnIndexOrThrow(colunas[2]));
            String horarioStr = c.getString(c.getColumnIndexOrThrow(colunas[3]));
            String observacao = c.getString(c.getColumnIndexOrThrow(colunas[4]));
            String nome_cliente = c.getString(c.getColumnIndexOrThrow(colunas[5]));

            Date horario = new Date();
            try {
                horario = new SimpleDateFormat("dd/MM/yyyy HH:MM").parse(horarioStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Atendimento atendimento =  new Atendimento(id, descricao, valor, horario, observacao, nome_cliente);

            atendimentos.add(atendimento);
        }

        return atendimentos;
    }
}
