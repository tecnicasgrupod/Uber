package com.tecnicas_pucrs.entidades;

import java.util.ArrayList;
import java.util.List;

import com.tecnicas_pucrs.entidades.Bairro;

public class Cidade {

    private String nome;
    private List<Bairro> listaDeBairros;

    public Cidade(String nome){
        this.nome = nome;
        this.listaDeBairros = new ArrayList<>();
    }

    public String nome(){
        return this.nome;
    }

    public List<Bairro> getListaDeBairros(){
        return this.listaDeBairros;
    }

}