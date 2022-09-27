package br.edu.femass.model;

import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.dao.DaoProfessor;

import java.util.List;

public class Professor extends Leitor {

    private String disciplina;

    public Professor() {

    }

    public Professor(String nome, String endereco,
                     String telefone, String disciplina) {
        super(nome, endereco, telefone);
        this.disciplina = disciplina;
        setPrazoMaximoDevolucao(30);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void atualizarCodigo() {
        Long maior = 0L;
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            for (Professor p: professores) {
                if (p.getCodigo() > maior) {
                    maior = p.getCodigo();
                    setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
