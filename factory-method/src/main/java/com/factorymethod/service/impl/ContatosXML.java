package com.factorymethod.service.impl;

import com.factorymethod.model.Contato;
import com.factorymethod.service.Contatos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.net.URL;
import java.util.Collection;
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
        // clear out existing permissions and set own ones
        xStream.addPermission(NoTypePermission.NONE);
        // allow some basics
        xStream.addPermission(NullPermission.NULL);
        xStream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xStream.allowTypeHierarchy(Collection.class);
        xStream.allowTypesByWildcard(new String[] {"com.factorymethod.**"});
        xStream.alias("contatos", List.class);
        xStream.alias("contato", Contato.class);

        URL url = this.getClass().getResource("/".concat(nomeArquivo));
        return (List<Contato>) xStream.fromXML(url);
    }
}
