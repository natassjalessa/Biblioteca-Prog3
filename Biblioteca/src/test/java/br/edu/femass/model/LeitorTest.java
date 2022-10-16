package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeitorTest {

    @Test
    void cadastroGeralLeitor() {

        Leitor leitor = new Leitor("Nome", "Endereco", "Telefone");

        String nomeEsperado = "Nome";
        String enderecoEsperado = "Endereco";
        String telefoneEsperado = "Telefone";

        Assertions.assertEquals(nomeEsperado, leitor.getNome());
        Assertions.assertEquals(enderecoEsperado, leitor.getEndereco());
        Assertions.assertEquals(telefoneEsperado, leitor.getTelefone());
    }

}