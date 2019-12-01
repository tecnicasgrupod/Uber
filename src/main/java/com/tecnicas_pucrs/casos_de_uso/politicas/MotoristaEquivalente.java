package com.tecnicas_pucrs.casos_de_uso.politicas;

import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoMotoristas;
import com.tecnicas_pucrs.entidades.CategoriaVeiculo;
import com.tecnicas_pucrs.entidades.Motorista;

public class MotoristaEquivalente implements PoliticasDeSelecao {

    public Motorista selecionaMotorista(CategoriaVeiculo categoriaVeiculo, double pontuacaoPassageiro, RepoMotoristas repoMotoristas){
        try{
            Motorista motorista_selecionado = repoMotoristas.getMotoristas().get(0);
            for (Motorista m : repoMotoristas.getMotoristas()){
                if(motorista_selecionado.getPontuacaoMedia() < m.getPontuacaoMedia()){
                    if(m.getPontuacaoMedia() <= pontuacaoPassageiro){
                        motorista_selecionado = m;
                    }
                }
            }
            return motorista_selecionado;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}