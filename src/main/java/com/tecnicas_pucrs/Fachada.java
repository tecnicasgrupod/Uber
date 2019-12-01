package com.tecnicas_pucrs;

import com.tecnicas_pucrs.casos_de_uso.politicas.CalculoCustoViagem;
import com.tecnicas_pucrs.casos_de_uso.politicas.SeletorDeMotorista;
import com.tecnicas_pucrs.casos_de_uso.repositorios.*;
import com.tecnicas_pucrs.entidades.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Fachada {

    private CalculoCustoViagem custoViagem;
    private SeletorDeMotorista selecaoMotorista;
    private RepoBairros bairros;
    private RepoCidades cidades;
    private RepoMotoristas motoristas;
    private RepoPassageiros passageiros;
    private RepoViagens viagens;

    public Fachada(CalculoCustoViagem custoViagem, SeletorDeMotorista selecaoMotorista, RepoBairros bairros, RepoCidades cidades, RepoMotoristas motoristas, RepoPassageiros passageiros, RepoViagens viagens) {
        this.custoViagem = custoViagem;
        this.selecaoMotorista = selecaoMotorista;
        this.bairros = bairros;
        this.cidades = cidades;
        this.motoristas = motoristas;
        this.passageiros = passageiros;
        this.viagens = viagens;
    }

    public Motorista buscaMotoristaPorCPF(String cpf){
        return motoristas.recuperarPorCPF(cpf);
    }

    public List<Integer> recuperaViagensDoMotorista(String cpfMotorista) {
        List<Integer> viagensDoMotorista = new ArrayList<>();

        Motorista motorista = motoristas.recuperarPorCPF(cpfMotorista);
        List<Viagem> todasViagens = viagens.getViagens();

        for (Viagem v : todasViagens) {
            if (v.getMotorista().getCPF().equals(motorista.getCPF())) {
                viagensDoMotorista.add(v.getId());
            }
        }

        return viagensDoMotorista;
    }

/**
    public Viagem solicitaVeiculoParaViagem(String cpf, String cidade, String bairroOrigem, String bairroDestino, String formaPagamento, String catVeiculo) {
        Passageiro passageiro = passageiros.recuperarPorCPF(cpf);
        Cidade cidadeD = cidades.recuperarPorNome(cidade);
        Bairro origem = bairros.recuperarPorNome(bairroOrigem);
        Bairro destino = bairros.recuperarPorNome(bairroDestino);
        Roteiro roteiro = new Roteiro(cidadeD, origem, destino);
        Motorista motorista = selecaoMotorista.selecionaMotoristaParaViagem(passageiro.getPontuacaoMedia(), catVeiculo, passageiro.getFormaPagamento());
        Veiculo veiculo = motorista.getVeiculo();
        double custo = custoViagem.custoViagem(roteiro, veiculo);
        Viagem viagem = new Viagem(1, LocalDateTime.now(), roteiro, motorista, passageiro, custo);
        //Persiste viagem no repositorio de viagens
        return viagem;
    }



    public boolean informaPontuacaoMotorista(String cpfMotorista) {
        return false;
    }

    public boolean informaPontuacaoPassageiro(String cpfPassageiro) {
        return false;
    }
**/
}
