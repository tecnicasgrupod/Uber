package com.tecnicas_pucrs.casos_de_uso.politicas;

import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoMotoristas;
import com.tecnicas_pucrs.entidades.CategoriaVeiculo;
import com.tecnicas_pucrs.entidades.Motorista;

public class MelhorMotorista implements PoliticasDeSelecao {

    public Motorista selecionaMotorista(CategoriaVeiculo categoriaVeiculo, double pontuacaoPassageiro, RepoMotoristas repoMotoristas){
        try{
            Motorista motorista_selecionado = repoMotoristas.getMotoristas().get(0); //considerar o pagameto
            for (Motorista m : repoMotoristas.getMotoristas()){
                if(motorista_selecionado.getPontuacaoMedia() < m.getPontuacaoMedia()){
                    motorista_selecionado = m;
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
