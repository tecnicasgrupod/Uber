package com.tecnicas_pucrs.casos_de_uso.repositorios;

import com.tecnicas_pucrs.entidades.Cidade;
import com.tecnicas_pucrs.interfaces.repositorios.IRepoCidades;
import com.tecnicas_pucrs.persistencia.PersistenciaCidades;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class RepoCidades implements IRepoCidades {

    private List<Cidade> cidades;

    public RepoCidades() throws IOException, URISyntaxException {
        this.cidades = PersistenciaCidades.carregaCidades();
    }

    public List<Cidade> getCidades() {
        return this.cidades;
    }

    public Cidade recuperarPorNome(String nome) {
        for (Cidade c : this.cidades) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cidade Inexistente");
    }
}