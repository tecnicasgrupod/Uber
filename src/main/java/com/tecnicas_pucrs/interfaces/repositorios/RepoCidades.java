package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Cidade;
import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.persistencia.PersistenciaCidades;
import com.tecnicas_pucrs.persistencia.PersistenciaMotoristas;
import com.tecnicas_pucrs.persistencia.PersistenciaVeiculos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RepoCidades {

    private List<Cidade> cidades;

    public RepoCidades() throws IOException, URISyntaxException {
        this.cidades = PersistenciaCidades.carregaCidades();
    }

    public List<Cidade> getCidades() {
        return this.cidades;
    }

    public Cidade recuperaPorNome(String nome) {
        for (Cidade c : this.cidades) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cidade Inexistente");
    }
}