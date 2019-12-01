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

    public Fachada(CalculoCustoViagem custoViagem, SeletorDeMotorista selecaoMotorista, RepoCidades cidades, RepoBairros bairros, RepoMotoristas motoristas) {
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

    public List<Viagem> recuperaViagensDoMotorista(String cpfMotorista) {
        List<Viagem> viagensDoMotorista = new ArrayList<>();

        Motorista motorista = motoristas.recuperarPorCPF(cpfMotorista);
        List<Viagem> todasViagens = viagens.getViagens();

        for (Viagem v : todasViagens) {
            if (v.getMotorista() == motorista) {
                viagensDoMotorista.add(v);
            }
        }

        return viagensDoMotorista;
    }

    public boolean informaPontuacaoMotorista(String cpfMotorista) {
        return false;
    }

    public boolean informaPontuacaoPassageiro(String cpfPassageiro) {
        return false;
    }
**/
}
