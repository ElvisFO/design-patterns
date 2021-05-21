package com.factorymethod.component;

import com.factorymethod.component.impl.MalaDiretaCSV;
import com.factorymethod.component.impl.MalaDiretaXML;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Elvis Fernandes on 20/05/2021
 * @project design-patterns
 */
public class MalaDiretaTest {

    @Test
    public void deveEnviarEmailLendoDeArquivoXML() {
        MalaDireta malaDireta = new MalaDiretaXML("contatos.xml");
        boolean enviado = malaDireta.enviarEmail("Tudo OK!");
        System.out.println(enviado);
        Assert.assertTrue(enviado);
    }

    @Test
    public void deveEnviarEmailLendoDeArquivoCSV() {
        MalaDireta malaDireta = new MalaDiretaCSV("contatos.csv");
        boolean enviado = malaDireta.enviarEmail("Tudo OK!");
        System.out.println(enviado);
        Assert.assertTrue(enviado);
    }
}
