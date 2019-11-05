package com.tecnicas_pucrs.entidades;

import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.FormaPagamento;

public class Motorista{
    
    private String cpf;
    private String nome;
    private Veiculo veiculo;
    private FormaPagamento pagamento;
    private int somatorioDeAvaliacoes;
    private int quantidadeDeAvaliacoes;

    public Motorista(String cpf, String nome, Veiculo v, FormaPagamento f){
        this.cpf = cpf;
        this.nome = nome;
        this.veiculo = v;
        this.pagamento = f;
        this.somatorioDeAvaliacoes = 0;
        this.quantidadeDeAvaliacoes = 0;
    }

    public String getCPF(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }
    
    public FormaPagamento getFormaPagamento(){
        return pagamento;
    }
    
    public int getSomatorioDeAvaliacoes(){
        return somatorioDeAvaliacoes;
    }

    public void incrementaQuantidadeDeAvalicoes(){
        this.quantidadeDeAvaliacoes++;
    }


    @Override
    public String toString() {
        return  "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", veiculo=(" + veiculo + ")" +
                ", pagamento=" + pagamento +
                ", somatorioDeAvaliacoes=" + somatorioDeAvaliacoes;
    }
}