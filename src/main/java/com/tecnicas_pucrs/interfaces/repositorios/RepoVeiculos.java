package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.persistencia.PersistenciaMotoristas;
import com.tecnicas_pucrs.persistencia.PersistenciaVeiculos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RepoVeiculos {

    private List<Veiculo> veiculos;

    public RepoVeiculos() throws IOException, URISyntaxException {
        this.veiculos = PersistenciaVeiculos.carregaVeiculos();
    }

    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public Veiculo recuperaPorPlaca(String placa) {
        for (Veiculo v : this.veiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Placa Inexistente");
    }
}