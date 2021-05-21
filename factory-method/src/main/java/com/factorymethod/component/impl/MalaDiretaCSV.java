package com.factorymethod.component.impl;

import com.factorymethod.component.MalaDireta;
import com.factorymethod.service.impl.ContatosCSV;
import com.factorymethod.service.Contatos;

/**
 * @author Elvis Fernandes on 03/06/2020
 * @project design-patterns
 */
public class MalaDiretaCSV extends MalaDireta {

    private final String nomeArquivo;

    public MalaDiretaCSV(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    protected Contatos criarContatos() {
        return new ContatosCSV(nomeArquivo);
    }
}
