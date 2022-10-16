package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void criarAluno() {

        Aluno aluno = new Aluno("Nome", "Endereco", "Telefone", "Matricula");

        String nomeEsperado = "Nome";
        String enderecoEsperado = "Endereco";
        String telefoneEsperado = "Telefone";
        String matriculaEsperado = "Matricula";

        Assertions.assertEquals(nomeEsperado, aluno.getNome());
        Assertions.assertEquals(enderecoEsperado, aluno.getEndereco());
        Assertions.assertEquals(telefoneEsperado, aluno.getTelefone());
        Assertions.assertEquals(matriculaEsperado, aluno.getMatricula());
    }

    @Test
    void atualizarCodigo() {

        Aluno aluno = new Aluno("Nome", "Endereco", "Telefone", "Matricula");

        aluno.atualizarCodigo();
        Long maior = 1L;

        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            for (Aluno al: alunos) {
                if (al.getCodigo() > maior) {
                    maior = al.getCodigo();
                    aluno.setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(maior, aluno.getCodigo());
    }

}