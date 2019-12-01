package com.tecnicas_pucrs.casos_de_uso.politicas;

import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoMotoristas;
import com.tecnicas_pucrs.entidades.CategoriaVeiculo;
import com.tecnicas_pucrs.entidades.Motorista;


public class SeletorDeMotorista{

    private PoliticasDeSelecao politica;

    public SeletorDeMotorista(PoliticasDeSelecao politica){
        this.politica = politica;
    }

    public void setPolitica(PoliticasDeSelecao politica) {
        this.politica = politica;
    }

    public Motorista getMotorista(CategoriaVeiculo categoriaVeiculo, double pontuacaoPassageiro, RepoMotoristas repoMotoristas){

        return politica.selecionaMotorista(categoriaVeiculo, pontuacaoPassageiro, repoMotoristas);
    }
}