package com.tecnicas_pucrs;

import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Passageiro;
import com.tecnicas_pucrs.entidades.Viagem;

import java.util.List;

public class Fachada {

    //Procura Motorista por CPF
    public Motorista procuraMotoristaPorCPF(String cpf){
        return null;
    }

    //
    public Viagem geraViagem(Motorista motorista, Passageiro passageiro){
        return null;
    }

    //Busca viagens do Motorista
    public List<Viagem> buscaViagensDoMotorista(String cpf){
        return null;
    }

    //Motorista avalia viajem do Passageiro
    public void AvaliaViagemDoPassageiro(Viagem viagem, int nota){

    }

    //Passageiro avalia viajem do Motorista
    public void AvaliaViagemDoMotorista(Viagem viagem, int nota){

    }
}
