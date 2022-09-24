package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    //Mudei Codigo para String pq nao sei converter Long na caixa de texto
    private String codigo;
    private String titulo;

    private List<Autor> autores = new ArrayList<>();



    public Livro(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
