package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Cidade;
import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.entidades.Viagem;
import com.tecnicas_pucrs.persistencia.PersistenciaCidades;
import com.tecnicas_pucrs.persistencia.PersistenciaMotoristas;
import com.tecnicas_pucrs.persistencia.PersistenciaVeiculos;
import com.tecnicas_pucrs.persistencia.PersistenciaViagens;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RepoViagens {

    private List<Viagem> viagens;

    public RepoViagens() throws IOException, URISyntaxException {
        this.viagens = PersistenciaViagens.carregaViagens();
    }

    public List<Viagem> getViagens() {
        return this.viagens;
    }

    public Viagem recuperaPorId(int id) {
        for (Viagem v : this.viagens) {
            if (v.getId() == id) {
                return v;
            }
        }
        throw new IllegalArgumentException("Viagem Inexistente");
    }
}