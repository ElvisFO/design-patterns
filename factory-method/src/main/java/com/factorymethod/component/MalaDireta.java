package com.factorymethod.component;

import com.factorymethod.model.Contato;
import com.factorymethod.service.Contatos;

import java.util.List;

/**
 * @author Elvis Fernandes on 03/06/2020
 * @project design-patterns
 */
public abstract class MalaDireta {

    protected abstract Contatos criarContatos();

    public boolean enviarEmail(String mensagem) {

        List<Contato> contatos = criarContatos().todos();
        System.out.println("Conectando no servidor SMTP...");
        System.out.println("Mensagem a ser enviada: " + mensagem);
        System.out.println();

        for (Contato contato : contatos) {
            System.out.println("From: <no-replay@gmail.com>");
            System.out.printf("To: [%s] <%s> \n", contato.getNome(), contato.getEmail());
            System.out.println(mensagem);
            System.out.println();
        }

        return true;
    }
}
