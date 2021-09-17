package com.example.aula3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarSegundaPagina(View view) {
        Intent intencao = new Intent(this, SegundaAtividade.class);
        startActivity(intencao);
    }

    public void fazerLigacao(View view) {
        Uri uri = Uri.parse("tel:37998726264");
        Intent ligacao = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(ligacao);
    }

    public void enviarEmail(View viuew) {
        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_EMAIL, new String[] {"italomedice969@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Teste envio email");
        email.putExtra(Intent.EXTRA_TEXT, "Aula de androd!!");
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Escolha seu app do gmail"));
        startActivity(email);
    }
}