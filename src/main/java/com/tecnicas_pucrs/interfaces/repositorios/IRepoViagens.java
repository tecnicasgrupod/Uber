package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Viagem;

import java.util.stream.Stream;

public interface IRepoViagens {

    public void cadastrarViagem(Viagem umaViagem);

    public Stream<Viagem> getViagens(Motorista motorista);

}
