package com.tecnicas_pucrs;


import com.tecnicas_pucrs.Veiculo;
import com.tecnicas_pucrs.ControleDeVeiculos;
//import com.tecnicas_pucrs.ControleDeMotoristas;
import com.tecnicas_pucrs.ControleDePassageiros;

public class App{

    public static void main(String[] args) {

        ControleDeVeiculos controleVeiculos = new ControleDeVeiculos();
        ControleDePassageiros controlePassageiros = new ControleDePassageiros();
        // TODO remover depois de completar classe PersistenciaMotoristas
        //ControleDeMotoristas controleMotoristas = new ControleDeMotoristas();

        System.out.println(" -----  Uber Tecnicas ------ ");

        System.out.println("\n Lista de Veiculos carregados:");
        for (Veiculo v : controleVeiculos.getTodosVeiculos()){
            System.out.println(v);
        }

        System.out.println("\n Lista de Motoristas carregados:");
        // TODO remover depois de completar classe PersistenciaMotoristas
        /*
        for (Motorista m : controleMotoristas.getTodosMotoristas()){
            System.out.println(v);
        }
        */

        System.out.println("\n Lista de Passageiros carregados:");
        for(Passageiro p :controlePassageiros.getTodosPassageiros()){
            System.out.println(p);
        }
        
        System.out.println("\n -----  Fim ------ ");
        
    }
}