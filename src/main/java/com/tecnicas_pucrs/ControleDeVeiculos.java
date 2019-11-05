package com.tecnicas_pucrs;

import java.util.ArrayList;
import java.util.List;

import com.tecnicas_pucrs.Veiculo;
import com.tecnicas_pucrs.entidades.CategoriaVeiculo;

public class ControleDeVeiculos{

    private static List<Veiculo> list;

    public ControleDeVeiculos(){
        try {
            list = PersistenciaVeiculos.carregaVeiculos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Veiculo getVeiculo(String placa){

        for(Veiculo v : list){
            if(placa.equals(v.getPlaca())){
                return v;
            }
        }

        return null;

    }

    public List<Veiculo> getVeiculo(CategoriaVeiculo categoria){
        List<Veiculo> aux = new ArrayList<Veiculo>();

        for(Veiculo v : list){
            if(categoria == v.getCategoria()){
                aux.add(v);
            }
        }

        return aux;

    }

    public List<Veiculo> getTodosVeiculos(){
        return list;
    }

}