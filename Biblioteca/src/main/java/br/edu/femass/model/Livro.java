package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private Long codigo;
    private static Long proximoLivroCodigo = 1L;
    private String titulo;
    private Autor autor;

    public Livro() {

    }


    public Livro(String titulo, Autor autor) {
        this.codigo = proximoLivroCodigo;
        proximoLivroCodigo++;
        this.titulo = titulo;
        this.autor = autor;

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String toString() {

        return this.codigo + " " + this.titulo + " " + getAutor();
    }

}
