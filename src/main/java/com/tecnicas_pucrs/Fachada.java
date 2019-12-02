package com.tecnicas_pucrs;

import com.tecnicas_pucrs.casos_de_uso.politicas.CalculoCustoViagem;
import com.tecnicas_pucrs.casos_de_uso.politicas.SeletorDeMotorista;
import com.tecnicas_pucrs.casos_de_uso.repositorios.*;
import com.tecnicas_pucrs.entidades.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fachada {

    private CalculoCustoViagem custoViagem;
    private SeletorDeMotorista selecaoMotorista;
    private RepoBairros bairros;
    private RepoCidades cidades;
    private RepoMotoristas motoristas;
    private RepoPassageiros passageiros;
    private RepoViagens viagens;

    public Fachada(CalculoCustoViagem custoViagem, SeletorDeMotorista selecaoMotorista) {
        this.custoViagem = custoViagem;
        this.selecaoMotorista = selecaoMotorista;
        this.bairros = RepoBairros.getInstance();
        this.cidades = RepoCidades.getInstance();
        this.motoristas = RepoMotoristas.getInstance();
        this.passageiros = RepoPassageiros.getInstance();
        this.viagens = RepoViagens.getInstance();
    }

    public HashMap<String, String> buscaMotoristaPorCPF(String cpf){
        Motorista motoristaAtual = motoristas.recuperarPorCPF(cpf);
        HashMap<String, String> motoristaRequest = new HashMap<>();
        motoristaRequest.put("cpfMotorista", motoristaAtual.getCPF());
        motoristaRequest.put("nome", motoristaAtual.getNome());
        return motoristaRequest;
    }

    public HashMap<String, String> buscaViagemPorId(int id){
        Viagem viagemAtual = viagens.recuperaPorId(id);
        HashMap<String, String> viagemRequest = new HashMap<>();
        viagemRequest.put("cpfPassageiro", viagemAtual.getPassageiro().getCPF());
        viagemRequest.put("data", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(viagemAtual.getDataHora()));
        viagemRequest.put("bairroOrigem", viagemAtual.getRoteiro().getBairroOrigem().getNome());
        viagemRequest.put("bairroDestino", viagemAtual.getRoteiro().getBairroDestino().getNome());
        viagemRequest.put("custo", Double.toString(viagemAtual.getCusto()));
        return viagemRequest;
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

    public void avaliaPassageiro(String cpfPassageiro, String nota) {
        Passageiro passageiro = passageiros.recuperarPorCPF(cpfPassageiro);
        passageiro.informaPontuacao(Integer.parseInt(nota));
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
