package com.factorymethod.component.impl;

import com.factorymethod.component.MalaDireta;
import com.factorymethod.service.Contatos;
import com.factorymethod.service.impl.ContatosXML;

/**
 * @author Elvis Fernandes on 03/06/2020
 * @project design-patterns
 */
public class MalaDiretaXML extends MalaDireta {

    private final String nomeArquivo;

    public MalaDiretaXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    protected Contatos criarContatos() {
        return new ContatosXML(nomeArquivo);
    }
}
