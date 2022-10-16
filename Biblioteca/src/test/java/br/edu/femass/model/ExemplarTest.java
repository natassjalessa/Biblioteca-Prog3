package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExemplarTest {

    @Test
    void cadastrarExemplar() {

        Livro livro = new Livro();
        Exemplar exemplar = new Exemplar(LocalDate.now(), livro);

        LocalDate dataEsperada = LocalDate.now();

        Assertions.assertEquals(dataEsperada, exemplar.getDataAquisicao());

    }

}