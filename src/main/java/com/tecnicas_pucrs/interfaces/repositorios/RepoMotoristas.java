package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.persistencia.PersistenciaMotoristas;
import com.tecnicas_pucrs.persistencia.PersistenciaVeiculos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RepoMotoristas{

    private List<Motorista> motoristas;

    public RepoMotoristas() throws IOException, URISyntaxException {
        this.motoristas = PersistenciaMotoristas.carregaMotoristas();
    }

    public List<Motorista> getMotoristas() throws IOException, URISyntaxException {
        return this.motoristas;
    }

    public Motorista recuperaPorCPF(String cpf){
        for (Motorista v: this.motoristas) {
            if(v.getCPF().equals(cpf)){
                return v;
            }
        }
        throw new IllegalArgumentException("Placa Inexistente" + cpf);
    }
}