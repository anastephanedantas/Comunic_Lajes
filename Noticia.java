package com.example.comuniclajes.com.example.comuniclajes.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.Serializable;
import java.util.List;

public class Noticia  implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String titulo;
    private String resumo;
    private String descricao;


    @Override
    public String toString() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    //public void remove(Noticia noticia) {
    //  noticias.remove(noticia);
    //notifyDataSetChanged();
    //}

//}

}
