package com.tecnicas_pucrs;

import java.util.List;
import com.tecnicas_pucrs.PersistenciaPassageiros;

public class ControleDePassageiros{

    private List<Passageiro> list;

    public ControleDePassageiros(){
        try {
            this.list = PersistenciaPassageiros.carregaPassageiros();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Passageiro getPassageiro(String nome){

        for(Passageiro p : list){
            if(nome.equals(p.getNome())){
                return p;
            }
        }

        return null;

    }

    public List<Passageiro> getTodosPassageiros(){
        return list;
    }

}