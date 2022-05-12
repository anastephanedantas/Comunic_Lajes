package com.example.comuniclajes.com.example.comuniclajes.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.comuniclajes.R;
import com.example.comuniclajes.com.example.comuniclajes.dao.DAO;
import com.example.comuniclajes.com.example.comuniclajes.model.Noticia;

public class NoticiaDetalhada extends AppCompatActivity {

     private Noticia noticia = new Noticia();

    @SuppressLint("UseValueOf")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia_detalhada);

        noticia = (Noticia) getIntent().getSerializableExtra("NOTICIA");

        TextView titulo = (TextView) findViewById(R.id.tituloNoticia);
        TextView resumo = (TextView) findViewById(R.id.resumoNoticia);
        TextView descricao = (TextView) findViewById(R.id.descricaoNoticia);

        titulo.setText(noticia.getTitulo());
        resumo.setText(noticia.getResumo());
        descricao.setText(noticia.getDescricao());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 4, 0, "Voltar");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 4){
            Intent intent = new Intent(this, Listagem.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
