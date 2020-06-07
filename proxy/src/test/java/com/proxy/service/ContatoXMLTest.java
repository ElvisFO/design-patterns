package com.proxy.service;

import com.proxy.service.Impl.ContatosXMLProxy;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Elvis Fernandes on 06/06/2020
 * @project design-patterns
 */
public class ContatoXMLTest {

    @Test
    public void deveRetornarNomeDoContato() {
        Contatos contatos = new ContatosXMLProxy("contatos.xml", "contatos1.xml");
        String nome = contatos.buscarPorEmail("david@gmail.com");
        Assert.assertEquals("David Silva", nome);
    }
}
