package com.proxy.service.Impl;

import com.proxy.model.Contato;
import com.proxy.service.Contatos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.util.*;

/**
 * @author Elvis Fernandes on 06/06/2020
 * @project design-patterns
 */
public class ContatosXML implements Contatos {

    private Map<String, String> cache = new HashMap<>();

    public ContatosXML(String... nomesArquivos) {

        XStream xStream = new XStream();
        // clear out existing permissions and set own ones
        xStream.addPermission(NoTypePermission.NONE);
        // allow some basics
        xStream.addPermission(NullPermission.NULL);
        xStream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xStream.allowTypeHierarchy(Collection.class);
        xStream.allowTypesByWildcard(new String[] {"com.proxy.**", "com.factorymethodlib.**"});
        xStream.alias("contatos", List.class);
        xStream.alias("contato", Contato.class);

        for (String nomeArquivo : nomesArquivos) {
            System.out.println("Carregando arquivo: " + nomeArquivo);
            List<Contato> contatos = (List<Contato>) xStream.fromXML(this.getClass().getResource("/" + nomeArquivo));
            contatos.forEach(c -> cache.put(c.getEmail(), c.getNome()));
        }
    }

    @Override
    public String buscarPorEmail(String email) {
        return this.cache.get(email);
    }
}
