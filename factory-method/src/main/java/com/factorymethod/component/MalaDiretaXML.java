package com.factorymethod.component;

import com.factorymethod.service.ContatosXML;
import com.factorymethodlib.commons.MalaDireta;
import com.factorymethodlib.service.Contatos;

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
