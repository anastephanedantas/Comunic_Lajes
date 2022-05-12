package com.example.comuniclajes.com.example.comuniclajes.view;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comuniclajes.R;
import com.example.comuniclajes.com.example.comuniclajes.dao.DAO;
import com.example.comuniclajes.com.example.comuniclajes.model.Noticia;

import java.util.List;

public class Listagem extends AppCompatActivity {

    private Noticia noticia;
    private Noticia noticiaSelecionada = new Noticia();
    private ListView lista;
    private Context context;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lista);

       lista = (ListView) findViewById(R.id.lista);
       carregaLista();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Noticia noticia = (Noticia) adapter.getItemAtPosition(position);
                Intent intent = new Intent(Listagem.this, NoticiaDetalhada.class);
                intent.putExtra("NOTICIA", noticia);
                startActivity(intent);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                noticiaSelecionada = (Noticia) adapter.getItemAtPosition(position);
                registerForContextMenu(lista);
                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "Cadastrar");
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista(){
        DAO dao = new DAO(this);
        List<Noticia> noticias = dao.getLista();
        dao.close();

        ArrayAdapter<Noticia> adapter = new ArrayAdapter<Noticia>(this, android.R.layout.simple_list_item_1, noticias);
        lista.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1){
            Intent intent = new Intent(this, Formulario.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}




