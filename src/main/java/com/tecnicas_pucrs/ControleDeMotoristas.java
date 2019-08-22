package com.tecnicas_pucrs;

import java.util.List;
import com.tecnicas_pucrs.PersistenciaMotoristas;

public class ControleDeMotoristas{

    private List<Motorista> list;

    public ControleDeMotoristas(){
        try {
            this.list = PersistenciaMotoristas.carregaMotoristas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Motorista getMotorista(String nome){

        for(Motorista m : list){
            if(nome.equals(m.getNome())){
                return m;
            }
        }

        return null;

    }

    public List<Motorista> getTodosMotoristas(){
        return list;
    }

}