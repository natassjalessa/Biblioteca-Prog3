package br.edu.femass;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Leitor;

public class App {

    public static void main(String[] args) {
        gerarProfessores();

    }

    /*public static void gerarAutores() {
        Autor a = new Autor("Pablo", "Vitar", "Brasileira");
        try {
            new DaoAutor().save(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void gerarProfessores() {
        Leitor l = new Leitor(1234L, "Carlos", "Rua", "329923822", 30);
        try {
            new DaoLeitor().save(l);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
