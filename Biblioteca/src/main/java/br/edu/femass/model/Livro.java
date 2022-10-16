package br.edu.femass.model;

import br.edu.femass.dao.DaoLivro;

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

    public void atualizarCodigo() {
        Long maior = 0L;
        try {
            List<Livro> livros = new DaoLivro().getAll();
            for (Livro l: livros) {
                if (l.getCodigo() > maior) {
                    maior = l.getCodigo();
                    setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

        return this.titulo + " " + getAutor();
    }

}
