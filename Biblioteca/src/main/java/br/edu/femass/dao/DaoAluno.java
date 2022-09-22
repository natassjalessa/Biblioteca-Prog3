package br.edu.femass.dao;

import br.edu.femass.model.Aluno;
import br.edu.femass.model.Professor;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoAluno extends Persistencia<Aluno> implements Dao<Aluno> {

    private final static String NOMEARQUIVO = "alunos.json";
    public void save(Aluno aluno) throws Exception {
        List<Aluno> alunos = getAll();
        alunos.add(aluno);
        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(alunos);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Aluno> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Aluno> alunos = getObjectmapper().readValue(json, new TypeReference<List<Aluno>>() {});
            return alunos;
        } catch (FileNotFoundException f) {
            return new ArrayList<>();
        } catch (Exception e) {
            throw e;
        }
    }
}
