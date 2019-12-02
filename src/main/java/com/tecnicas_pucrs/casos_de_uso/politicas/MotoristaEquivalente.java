package com.tecnicas_pucrs.casos_de_uso.politicas;

import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoMotoristas;
import com.tecnicas_pucrs.entidades.CategoriaVeiculo;
import com.tecnicas_pucrs.entidades.FormaPagamento;
import com.tecnicas_pucrs.entidades.Motorista;

import java.util.List;

public class MotoristaEquivalente implements PoliticasDeSelecao {

    public Motorista selecionaMotorista(CategoriaVeiculo categoriaVeiculo, double pontuacaoPassageiro, RepoMotoristas repoMotoristas, FormaPagamento formaPagamento) {
        try{
            List<Motorista> listaParcial = repoMotoristas.getMotoristas();
            listaParcial.removeIf(m -> !m.getFormaPagamento().equals(formaPagamento));
            Motorista motorista_selecionado = listaParcial.get(0);
            for (Motorista m : listaParcial){
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