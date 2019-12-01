package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Passageiro;

import java.util.List;

public interface IRepoPassageiros {

    public Passageiro recuperarPorCPF(String cpf);

    public List<Passageiro> getPassageiros();

    public void atualizaPassageiro(Passageiro passageiro);

}
