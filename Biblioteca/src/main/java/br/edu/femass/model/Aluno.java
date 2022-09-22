package br.edu.femass.model;

public class Aluno extends Leitor {

    private String matricula;

    public Aluno() {

    }

    public Aluno(Long codigo, String nome, String endereco,
                 String telefone, Integer prazoMaximoDevolucao, String matricula) {
        super(codigo, nome, endereco, telefone, prazoMaximoDevolucao);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
