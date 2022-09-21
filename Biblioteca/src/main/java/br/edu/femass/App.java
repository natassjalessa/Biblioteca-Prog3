package br.edu.femass;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

public class App {

    public static void main(String[] args) {
        Autor autor = new Autor("Naruto", "Uzumaki", "Japones");
        DaoAutor dao = new DaoAutor();
        try {
            dao.gravar(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
