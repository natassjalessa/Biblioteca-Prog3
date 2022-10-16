package br.edu.femass.model;

import br.edu.femass.dao.DaoProfessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void criarProfessor() {

        Professor professor = new Professor("Nome", "Endereco", "Telefone",
                "Disciplina");

        String nomeEsperado = "Nome";
        String enderecoEsperado = "Endereco";
        String telefoneEsperado = "Telefone";
        String disciplinaEsperado = "Disciplina";

        Assertions.assertEquals(nomeEsperado, professor.getNome());
        Assertions.assertEquals(enderecoEsperado, professor.getEndereco());
        Assertions.assertEquals(telefoneEsperado, professor.getTelefone());
        Assertions.assertEquals(disciplinaEsperado, professor.getDisciplina());
    }

    @Test
    void atualizarCodigo() {

        Professor professor = new Professor("Nome", "Endereco", "Telefone",
                "Disciplina");
        professor.atualizarCodigo();
        Long maior = 1L;
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            for (Professor p: professores) {
                if (p.getCodigo() > maior) {
                    maior = p.getCodigo();
                    professor.setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(maior, professor.getCodigo());
    }
}