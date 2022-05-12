package com.example.comuniclajes.com.example.comuniclajes.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comuniclajes.R;
import com.example.comuniclajes.com.example.comuniclajes.dao.DAO;
import com.example.comuniclajes.com.example.comuniclajes.model.Noticia;

public class Formulario extends AppCompatActivity {

    private Noticia notica = new Noticia();
    EditText titulo;
    EditText resumo;
    EditText descricao;
    boolean dadosValidados;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



        Button botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                titulo = (EditText) findViewById(R.id.titulo);
                resumo = (EditText) findViewById(R.id.resumo);
                descricao = (EditText) findViewById(R.id.descricao);


                dadosValidados = validarCampos();

                if (dadosValidados){
                    Intent intent = new Intent(Formulario.this, Listagem.class);
                    startActivity(intent);


                    notica.setTitulo(titulo.getEditableText().toString());
                notica.setResumo(resumo.getEditableText().toString());
                notica.setDescricao(descricao.getEditableText().toString());

                DAO dao = new DAO(Formulario.this);
                dao.inserir(notica);
                dao.close();

                Toast.makeText(Formulario.this, "Notícia adicionada!", Toast.LENGTH_LONG).show();
                finish();
            }else {

                    Toast.makeText(Formulario.this, "Confira os campos!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 3, 0, "Voltar");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 3){
            Intent intent = new Intent(this, Listagem.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validarCampos(){

        boolean retorno = false;

        if(!TextUtils.isEmpty(titulo.getText().toString())){

            retorno = true;
        }else{
            titulo.setError("*");
            titulo.requestFocus();
        }

        if(!TextUtils.isEmpty(resumo.getText().toString())){

            retorno = true;
        }else{
            resumo.setError("*");
            resumo.requestFocus();
        }

        if(!TextUtils.isEmpty(descricao.getText().toString())){

            retorno = true;

        }else{
            descricao.setError("*");
            descricao.requestFocus();
        }

        return retorno;


    }

}