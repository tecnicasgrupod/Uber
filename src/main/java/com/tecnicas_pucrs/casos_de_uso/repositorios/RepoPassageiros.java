package com.tecnicas_pucrs.casos_de_uso.repositorios;

import com.tecnicas_pucrs.entidades.Passageiro;
import com.tecnicas_pucrs.interfaces.repositorios.IRepoPassageiros;
import com.tecnicas_pucrs.persistencia.PersistenciaBairros;
import com.tecnicas_pucrs.persistencia.PersistenciaMotoristas;
import com.tecnicas_pucrs.persistencia.PersistenciaPassageiros;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class RepoPassageiros implements IRepoPassageiros {

    private List<Passageiro> passageiros;

    public RepoPassageiros() throws IOException, URISyntaxException {
        this.passageiros = PersistenciaPassageiros.carregaPassageiros();
    }

    public boolean persistePassageiros(){
        try {
            return PersistenciaPassageiros.persistePassageiros(passageiros);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Passageiro> getPassageiros() {
        return this.passageiros;
    }

    public Passageiro recuperarPorCPF(String cpf) {
        for (Passageiro p : this.passageiros) {
            if (p.getCPF().equals(cpf)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Passageiro Inexistente");
    }

}