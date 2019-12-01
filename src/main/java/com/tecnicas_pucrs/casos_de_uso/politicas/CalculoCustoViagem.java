package com.tecnicas_pucrs.casos_de_uso.politicas;

import com.tecnicas_pucrs.entidades.Bairro;
import com.tecnicas_pucrs.entidades.CategoriaVeiculo;
import com.tecnicas_pucrs.entidades.Roteiro;


public class CalculoCustoViagem{

    private PoliticasDeCusto politica;
    private Roteiro roteiro;
    private CategoriaVeiculo categoriaVeiculo;


    public CalculoCustoViagem(PoliticasDeCusto politica, Roteiro roteiro, CategoriaVeiculo categoriaVeiculo) {
        this.politica = politica;
        this.roteiro = roteiro;
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public void setPolitica(PoliticasDeCusto politica) {
        this.politica = politica;
    }

    public double getCusto(){
        double custo_base = 0;
        for (Bairro b : roteiro.bairrosPercorridos()) {
            custo_base += b.getCustoBasico();
        }

        if (categoriaVeiculo.equals(CategoriaVeiculo.SIMPLES)){
            return custo_base * politica.ModificadorDeCusto();
        }

        if (categoriaVeiculo.equals(CategoriaVeiculo.NORMAL)){
            return (custo_base * 1.1) * politica.ModificadorDeCusto();
        }

        if (categoriaVeiculo.equals(CategoriaVeiculo.LUXO)){
            int quantidade_de_bairros = roteiro.bairrosPercorridos().size();
            return (custo_base * 1.1) * (1 + (quantidade_de_bairros *0.02)) * politica.ModificadorDeCusto();
        }

        return 0;
    }
}