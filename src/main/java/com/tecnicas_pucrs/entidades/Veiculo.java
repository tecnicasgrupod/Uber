package com.tecnicas_pucrs.entidades;

import com.tecnicas_pucrs.CategoriaVeiculo;

public class Veiculo {

    private String placa;
    private String marca;
    private String cor;
    private CategoriaVeiculo cat;


    public Veiculo(String placa, String marca, String cor, CategoriaVeiculo cat){
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.cat = cat;
    }

    public String getPlaca(){
        return placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getCor(){
        return cor;
    }

    public CategoriaVeiculo getCategoria(){
        return cat;
    }

    @Override
    public String toString(){
        return getPlaca() + "," + getMarca() + "," + getCor() + "," + getCategoria();
    }
}