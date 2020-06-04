package com.factorymethod.service;

import com.factorymethodlib.model.Contato;
import com.factorymethodlib.service.Contatos;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

/**
 * @author Elvis Fernandes on 03/06/2020
 * @project design-patterns
 */
public class ContatosXML implements Contatos {

    private final String nomeArquivo;

    public ContatosXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public List<Contato> todos() {

        XStream xStream = new XStream();
        xStream.alias("contatos", List.class);
        xStream.alias("contato", Contato.class);

        URL url = this.getClass().getResource("/".concat(nomeArquivo));
        return (List<Contato>) xStream.fromXML(url);
    }
}
