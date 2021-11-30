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
    private static final String[] colunas = {"_id_usuario", "nome", "email",  "senha"};
    private static final int ID_USUARIO = 0;
    private static final int NOME = 1;
    private static final int EMAIL = 2;
    private static final int SENHA = 3;

    private SQLiteDatabase database;

    public DAOUsuario(Context context) {
        super(context);
        database = dbCore.getWritableDatabase();
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
            Long id = c.getLong(c.getColumnIndexOrThrow(colunas[ID_USUARIO]));
            String nome = c.getString(c.getColumnIndexOrThrow(colunas[NOME]));
            String email = c.getString(c.getColumnIndexOrThrow(colunas[EMAIL]));

            Usuario u = new Usuario(id, nome, email);

            usuarios.add(u);
        }

        return usuarios;
    }

    public Long authLogin(Usuario u) {
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

        while (c.moveToNext()) {
            Long id = c.getLong(c.getColumnIndexOrThrow(colunas[ID_USUARIO]));
            String nome = c.getString(c.getColumnIndexOrThrow(colunas[NOME]));
            String email = c.getString(c.getColumnIndexOrThrow(colunas[EMAIL]));
            String senha = c.getString(c.getColumnIndexOrThrow(colunas[SENHA]));

            Usuario uAux = new Usuario(id, nome, email, senha);

            if (uAux.getEmail().equals(u.getEmail()) && uAux.getSenha().equals(u.getSenha())) {
                return id;
            }
        }

        return null;
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
