package com.proxy.service.Impl;

import com.proxy.service.Contatos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Elvis Fernandes on 06/06/2020
 * @project design-patterns
 */
public class ContatosXMLProxy implements Contatos {

    private ContatosXML contatosXML;
    private List<String> nomesArquivos;

    public ContatosXMLProxy(String... nomesArquivos) {
        this.nomesArquivos = new ArrayList<>(Arrays.asList(nomesArquivos));
    }

    @Override
    public String buscarPorEmail(String email) {

        String nome = null;
        Random random = new Random();
        int quantidadeArquivos = nomesArquivos.size();

        for (int i = 0; i < quantidadeArquivos; i++) {
            int indiceParaPesquisa = random.nextInt(nomesArquivos.size());

            String nomeArquivo = nomesArquivos.remove(indiceParaPesquisa);
            contatosXML = new ContatosXML(nomeArquivo);
            nome = contatosXML.buscarPorEmail(email);
            if(nome != null) break;
        }
        return nome;
    }
}
