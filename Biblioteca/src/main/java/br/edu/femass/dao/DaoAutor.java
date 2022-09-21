package br.edu.femass.dao;

import br.edu.femass.model.Autor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaoAutor {

    private static List<Autor> autores = new ArrayList<Autor>();

    public void gravar(Autor autor) throws Exception {
        //1 Adiciona objeto a lista
        autores.add(autor);

        //2 Gera JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(autores);

        //3 Grava arquivo no disco
        FileOutputStream out = new FileOutputStream("autor.json");
        out.write(json.getBytes());
        out.close();
    }

    public List<Autor> getAutores() throws Exception {

        //1 Ler arquivo
        FileInputStream in = new FileInputStream("autor.json");
        String json = new String (in.readAllBytes());

        //2 Converter conteudo do arquivo em objeto
        ObjectMapper objectMapper = new ObjectMapper();
        autores = objectMapper.readValue(json, new TypeReference<List<Autor>>(){});

        //3 Devolver a lista de objetos
        return autores;


    }
}