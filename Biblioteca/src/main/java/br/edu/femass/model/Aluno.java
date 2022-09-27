package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoLeitor;

import java.util.List;

public class Aluno extends Leitor {

    private String matricula;

    public Aluno() {

    }

    public Aluno(String nome, String endereco,
                 String telefone, String matricula) {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        setPrazoMaximoDevolucao(15);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void atualizarCodigo() {
        Long maior = 0L;
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            for (Aluno al: alunos) {
                if (al.getCodigo() > maior) {
                    maior = al.getCodigo();
                    setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
