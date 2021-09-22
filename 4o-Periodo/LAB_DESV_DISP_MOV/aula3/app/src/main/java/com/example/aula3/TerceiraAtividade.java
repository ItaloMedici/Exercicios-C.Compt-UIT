package com.example.aula3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class TerceiraAtividade extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_actibity);
    }

    public void chamarPrimeiraPagina(View view) {
        Intent intent = new Intent(TerceiraAtividade.this, MainActivity.class);
        startActivity(intent);
    }

    public void chamarSegundaPagina(View view) {
        Intent intencao = new Intent(this, SegundaAtividade.class);
        startActivity(intencao);
    }
}
