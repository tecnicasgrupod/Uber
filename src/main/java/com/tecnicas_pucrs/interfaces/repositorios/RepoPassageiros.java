package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Passageiro;
import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.persistencia.PersistenciaMotoristas;
import com.tecnicas_pucrs.persistencia.PersistenciaPassageiros;
import com.tecnicas_pucrs.persistencia.PersistenciaVeiculos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RepoPassageiros {

    private List<Passageiro> passageiros;

    public RepoPassageiros() throws IOException, URISyntaxException {
        this.passageiros = PersistenciaPassageiros.carregaPassageiros();
    }

    public List<Passageiro> getPassageiros() {
        return this.passageiros;
    }

    public Passageiro recuperaPorCPF(String cpf) {
        for (Passageiro p : this.passageiros) {
            if (p.getCPF().equals(cpf)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Passageiro Inexistente");
    }
}