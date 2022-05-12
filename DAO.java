package com.example.comuniclajes.com.example.comuniclajes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import com.example.comuniclajes.com.example.comuniclajes.model.Noticia;

import java.util.ArrayList;
import java.util.List;

public class DAO extends SQLiteOpenHelper {
    //private Noticia noticiaEscolhida;
    private  static final int VERSAO = 1;
   private List<Noticia> lista;
    private static final String TABELA = "Noticia";
    private static final String[] COLS = {"id", "titulo", "resumo", "descricao"};
    private SQLiteDatabase db;
    private DAO dao;

    public DAO (Context context){
        super(context, TABELA, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABELA + " ");
        sb.append("(id PRIMARY KEY, ");
        sb.append(" titulo TEXT, ");
        sb.append(" resumo TEXT, ");
        sb.append(" descricao TEXT);");
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS " + TABELA);
        db.execSQL(sb.toString());
        onCreate(db);
    }

    public void inserir (Noticia noticia){
        ContentValues values = new ContentValues();
        values.put("titulo", noticia.getTitulo());
        values.put("resumo", noticia.getResumo());
        values.put("descricao", noticia.getDescricao());
        getWritableDatabase().insert(TABELA, null, values);
    }



    public List<Noticia> getLista(){
        List<Noticia> noticias = new ArrayList<Noticia>();

        Cursor c = getWritableDatabase().query(TABELA, COLS, null, null,null,null, null );

        try {


        while (c.moveToNext()) {
            Noticia noticia = new Noticia();
            noticia.setId(c.getLong(0));
            noticia.setTitulo(c.getString(1));
            noticia.setResumo(c.getString(2));
            noticia.setDescricao(c.getString(3));

            noticias.add(noticia);
            }
        }finally {
            c.close();
        }

        return noticias;
    }


}


