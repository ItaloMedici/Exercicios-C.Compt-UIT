package com.example.agendamentohorarios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.agendamentohorarios.usuario.Usuario;

import java.util.List;

public abstract class DBUtils {

    protected DBCore dbCore;

    public DBUtils(Context context) {
        dbCore = new DBCore(context);
    }

    public abstract void insert(Object o);

    public abstract void delete(Object o);

    public abstract void update(Object o);

    public abstract List<?> search();

}
