package com.example.aula3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class SegundaAtividade extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    public void chamarTerceiraPagina(View view) {
        Intent intent = new Intent(SegundaAtividade.this, TerceiraAtividade.class);
        startActivity(intent);
    }

    public void chamarPrimeiraPagina(View view) {
        Intent intent = new Intent(SegundaAtividade.this, MainActivity.class);
        startActivity(intent);
    }
}
