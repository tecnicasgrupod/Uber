package com.tecnicas_pucrs.interfaces.repositorios;

import com.tecnicas_pucrs.entidades.Cidade;

import java.util.List;

public interface IRepoCidades {

    public Cidade recuperarPorNome(String nome);

    public List<Cidade> getCidades();
}
