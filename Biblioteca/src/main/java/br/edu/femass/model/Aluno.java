package br.edu.femass.model;

public class Aluno extends Leitor {

    private String matricula;

    public Aluno() {

    }

    public Aluno(String nome, String endereco,
                 String telefone, String matricula) {
        super(nome, endereco, telefone);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
