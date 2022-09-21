package br.edu.femass.model;

public class Autor {

    private String nome;
    private String sobreNome;
    private String nacionalidade;

    public Autor() {

    }

    public Autor(String nome, String sobreNome, String nacionalidade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nacionalidade = nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getSobreNome() {
        return sobreNome;
    }

}
