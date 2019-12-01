package com.tecnicas_pucrs.casos_de_uso.repositorios;

import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.interfaces.repositorios.IRepoMotoristas;
import com.tecnicas_pucrs.persistencia.PersistenciaMotoristas;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class RepoMotoristas implements IRepoMotoristas {

    private List<Motorista> motoristas;

    public RepoMotoristas() throws IOException, URISyntaxException {
        this.motoristas = PersistenciaMotoristas.carregaMotoristas();
    }

    public List<Motorista> getMotoristas() {
        return this.motoristas;
    }

    public Motorista recuperarPorCPF(String cpf){
        for (Motorista v: this.motoristas) {
            if(v.getCPF().equals(cpf)){
                return v;
            }
        }
        throw new IllegalArgumentException("Placa Inexistente" + cpf);
    }
}