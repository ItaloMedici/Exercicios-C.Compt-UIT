package com.example.agendamentohorarios.atendimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.agendamentohorarios.DBUtils;
import com.example.agendamentohorarios.usuario.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOAtendimento extends DBUtils {

    private SQLiteDatabase database;
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

    private static final int ID_ATDIMENTO = 0;
    private static final int DESCRICAO = 1;
    private static final int VALOR = 2;
    private static final int HORARIO = 3;
    private static final int OBSERVACAO = 4;
    private static final int NOME_CLIENTE = 5;
    private static final int ID_USUARIO = 6;

    public DAOAtendimento(Context context) {
        super(context);
        database = dbCore.getWritableDatabase();
    }

    @Override
    public void insert(Object o) {
        Atendimento atd = (Atendimento) o;

        ContentValues values = new ContentValues();
        values.put(colunas[DESCRICAO], atd.getDescricao());
        values.put(colunas[NOME_CLIENTE], atd.getNomeCliente());
        values.put(colunas[VALOR], atd.getValor());
        values.put(colunas[HORARIO], new SimpleDateFormat("dd/MM/yyyy HH:MM").format(atd.getHorario()));
        values.put(colunas[OBSERVACAO], atd.getObservacao());
        values.put(colunas[ID_USUARIO], atd.getUsuario().getIdentificador());

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

        String whereClause = colunas[ID_USUARIO] + " = ? ";
        String[] whereArgs = new String[] {
                u.getIdentificador().toString()
        };

        Cursor c = database.query(
                table, colunas,
                whereClause, whereArgs,
                null, null, colunas[HORARIO]
        );

        while (c.moveToNext()) {
            Long id = c.getLong(c.getColumnIndexOrThrow(colunas[ID_ATDIMENTO]));
            String descricao = c.getString(c.getColumnIndexOrThrow(colunas[DESCRICAO]));
            Double valor = c.getDouble(c.getColumnIndexOrThrow(colunas[VALOR]));
            String horarioStr = c.getString(c.getColumnIndexOrThrow(colunas[HORARIO]));
            String observacao = c.getString(c.getColumnIndexOrThrow(colunas[OBSERVACAO]));
            String nome_cliente = c.getString(c.getColumnIndexOrThrow(colunas[NOME_CLIENTE]));

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
