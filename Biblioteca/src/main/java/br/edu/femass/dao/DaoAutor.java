package br.edu.femass.dao;

import br.edu.femass.model.Autor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoAutor extends Persistencia<Autor> implements Dao<Autor> {

    private final static String NOMEARQUIVO = "autores.json";

    public void save(Autor autor) throws Exception {
        List<Autor> autores = getAll();
        autores.add(autor);
        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(autores);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Autor> getAll() throws Exception {
        try {
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Autor> autores = getObjectmapper().readValue(json, new TypeReference<List<Autor>>(){});
            return autores;
        } catch (FileNotFoundException f) {
            return new ArrayList();
        } catch (Exception e) {
            throw e;
        }
    }
}