package com.factorymethod.component;

import com.factorymethod.service.ContatosCSV;
import com.factorymethodlib.commons.MalaDireta;
import com.factorymethodlib.service.Contatos;

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
