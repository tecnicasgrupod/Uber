package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Passageiro;
import com.tecnicas_pucrs.entidades.Veiculo;

import java.util.List;

public interface IRepoVeiculos {

    public Veiculo recuperarPorPlaca(String placa);

    public List<Veiculo> getVeiculos();

}
