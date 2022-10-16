package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoLivro;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void cadastrarLivro() {

        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");
        Livro livro = new Livro("Titulo", autor);

        String tituloEsperado = "Titulo";

        Assertions.assertEquals(tituloEsperado, livro.getTitulo());

    }

    @Test
    void atualizarCodigo() {

        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");
        Livro livro = new Livro("Titulo", autor);

        livro.atualizarCodigo();
        Long maior = 1L;

        try {
            List<Livro> livros = new DaoLivro().getAll();
            for (Livro l: livros) {
                if (l.getCodigo() > maior) {
                    maior = l.getCodigo();
                    livro.setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(maior, livro.getCodigo());
    }
}