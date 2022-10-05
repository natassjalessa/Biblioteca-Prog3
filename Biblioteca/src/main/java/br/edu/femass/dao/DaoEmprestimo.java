package br.edu.femass.dao;

import br.edu.femass.model.Emprestimo;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoEmprestimo extends Persistencia<Emprestimo> implements Dao<Emprestimo> {

    private final static String NOMEARQUIVO = "emprestimos.json";

    public void save(Emprestimo emprestimo) throws Exception {
        List<Emprestimo> emprestimos = getAll();
        emprestimos.add(emprestimo);
        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(emprestimos);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Emprestimo> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Emprestimo> emprestimos = getObjectmapper().readValue(json, new TypeReference<List<Emprestimo>>(){});
            return emprestimos;
        } catch (FileNotFoundException f) {
            return new ArrayList();
        } catch (Exception e) {
            throw e;
        }
    }
}
