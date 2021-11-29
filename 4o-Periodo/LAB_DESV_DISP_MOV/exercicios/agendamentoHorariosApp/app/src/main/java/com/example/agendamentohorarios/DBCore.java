package com.example.agendamentohorarios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.agendamentohorarios.usuario.Usuario;

import java.util.Date;

public class DBCore extends SQLiteOpenHelper {

    public static final String nameDB = "bancoBeaute";
    public static final int versionDB = 1;

    public DBCore(Context context) {
        super(context, nameDB, null, versionDB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUsuario = "" +
                "CREATE TABLE usuario (" +
                "   _id_usuario INTEGER primary key autoincrement," +
                "   nome TEXT NOT NULL," +
                "   senha TEXT NOT NULL," +
                "   email TEXT NOT NULL UNIQUE" +
                "); " ;

        String createAtendimento = "" +
            "CREATE TABLE atendimento (" +
            "   _id_atendimento INTEGER PRIMARY KEY AUTOINCREMENT," +
            "   descricao TEXT NOT NULL," +
            "   nome_cliente TEXT NOT NULL," +
            "   observacao TEXT," +
            "   horario TEXT NOT NULL," +
            "   valor DOUBLE NOT NULL," +
            "   _id_usuario INTEGER NOT NULL, " +
            "   FOREIGN KEY (_id_usuario) REFERENCES usuario(_id_usuario)" +
            ");";

        sqLiteDatabase.execSQL(createUsuario);
        sqLiteDatabase.execSQL(createAtendimento);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table usuario");
        sqLiteDatabase.execSQL("drop table atendimento");
        onCreate(sqLiteDatabase);
    }
}
