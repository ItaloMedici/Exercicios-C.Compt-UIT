package com.example.agendamentohorarios.usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.agendamentohorarios.DBUtils;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario extends DBUtils {

    private static final String table = "usuario";
    private static final String[] colunas = {"_id_usuario", "nome", "email"};


    public DAOUsuario(Context context) {
        super(context);
    }

    @Override
    public void insert(Object u) {
        Usuario usuario = (Usuario) u;

        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());

        database.insert(table, null, values);
    }

    @Override
    public void delete(Object usuario) {
        Usuario u = (Usuario) usuario;
    }

    @Override
    public void update(Object usuario) {
        Usuario u = (Usuario) usuario;
    }

    @Override
    public List<Usuario> search() {
        List<Usuario> usuarios = new ArrayList<>();

        Cursor c = database.query(
                table, colunas,
                null, null,
                null, null, "nome"
        );

        while (c.moveToNext()) {
            Long id = c.getLong(c.getColumnIndexOrThrow(colunas[0]));
            String nome = c.getString(c.getColumnIndexOrThrow(colunas[1]));
            String email = c.getString(c.getColumnIndexOrThrow(colunas[2]));

            Usuario u = new Usuario(id, nome, email);
        }

        return usuarios;
    }

    public boolean authLogin(Usuario u) {
        String whereClause = "email = ? AND senha = ?";
        String[] whereArgs = new String[] {
                u.getEmail(),
                u.getSenha()
        };

        Cursor c = database.query(
                table, colunas,
                whereClause, whereArgs,
                null, null, "nome"
        );

//        if (c.getCount() > 0) {
//            return true;
//
//            do {
//                int id = c.getColumnIndex(colunas[0]);
//                int nome = c.getColumnIndex(colunas[1]);
//                int email = c.getColumnIndex(colunas[2]);
//
//                Usuario uAux = new Usuario(c.getLong(id), c.getString(nome), c.getString(email));
//
//                if (uAux.getEmail().equals(u.getEmail()) && uAux.getSenha().equals(u.getSenha())) {
//                    return true;
//                }
//
//            } while (c.moveToNext());
//        }
//
//        return false;

        return c.getCount() > 0;
    }

    public Long getIDByEmail(String email) {
        List<Usuario> usuarios = search();

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) return u.getIdentificador();
        }

        return  null;
    }

    public Usuario getUsuarioByID(Long id) {
        List<Usuario> usuarios = search();

        for (Usuario u : usuarios) {
            if (u.getIdentificador().equals(id)) return u;
        }

        return new Usuario();
    }
}
