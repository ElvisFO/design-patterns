package com.factorymethod.service;

import au.com.bytecode.opencsv.CSVReader;
import com.factorymethodlib.model.Contato;
import com.factorymethodlib.service.Contatos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elvis Fernandes on 03/06/2020
 * @project design-patterns
 */
public class ContatosCSV implements Contatos {

    private final String nomeArquivo;

    public ContatosCSV(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }


    @Override
    public List<Contato> todos() {

        List<Contato> contatos = new ArrayList<>();
        CSVReader csvReader = null;

        try {
            URI uri = this.getClass().getResource("/".concat(nomeArquivo)).toURI();
            File file = new File(uri);
            FileReader fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contatos.add(new Contato(nextLine[0], nextLine[1]));
            }

        } catch (Exception e) {

            throw new RuntimeException("Erro ao ler arquivo: " + nomeArquivo);
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contatos;
    }
}
