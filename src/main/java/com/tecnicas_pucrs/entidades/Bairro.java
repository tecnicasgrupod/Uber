package com.tecnicas_pucrs.entidades;

import com.tecnicas_pucrs.entidades.geometria.Area;

public class Bairro{

    private String nome;
    private Area limites;
    private int custoBasico;

    public Bairro(String nome, Area limites, int custoBasico){
        this.nome = nome;
        this.limites = limites;
        this.custoBasico = custoBasico;
    }

    public String nome(){
        return this.nome;
    }

    public Area getLimites(){
        return this.limites;
    }

    public int getCustoBasico(){
        return this.custoBasico;
    }

}