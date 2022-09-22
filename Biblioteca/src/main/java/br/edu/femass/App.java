package br.edu.femass;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

public class App {

    public static void main(String[] args) {
        gerarAutores();

    }

    public static void gerarAutores() {
        Autor a = new Autor("Pablo", "Vitar", "Brasileira");
        try {
            new DaoAutor().save(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
