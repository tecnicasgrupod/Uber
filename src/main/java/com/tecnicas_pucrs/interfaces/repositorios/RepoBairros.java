package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Bairro;
import com.tecnicas_pucrs.persistencia.PersistenciaBairros;

import java.io.IOException;
import java.util.List;

public class RepoBairros {

    private List<Bairro> bairros;

    public RepoBairros() throws IOException {
        this.bairros = PersistenciaBairros.carregaBairros();
    }

    public List<Bairro> getBairros() {
        return this.bairros;
    }

    public Bairro recuperaPorNome(String nome) {
        for (Bairro b : this.bairros) {
            if (b.getNome().equals(nome)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Bairro Inexistente");
    }
}