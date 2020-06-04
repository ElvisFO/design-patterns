package com.factorymethod;

import com.factorymethod.component.MalaDiretaCSV;
import com.factorymethod.component.MalaDiretaXML;
import com.factorymethodlib.commons.MalaDireta;

/**
 * @author Elvis Fernandes on 03/06/2020
 * @project design-patterns
 */
public class Application {

    public static void main(String[] args) {

        MalaDireta malaDireta = new MalaDiretaXML("contatos.xml");
        boolean enviado = malaDireta.enviarEmail("Tudo OK!");
        System.out.println(enviado);

    }
}
