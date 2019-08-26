package com.tecnicas_pucrs;

import com.tecnicas_pucrs.Veiculo;
import com.tecnicas_pucrs.FormaPagamento;

public class Motorista{
    
    private String cpf;
    private String nome;
    private Veiculo veiculo;
    private FormaPagamento pagamento;
    private int pontuacaoMedia;
    private int contaCorridas;

    public Motorista(String cpf, String nome, Veiculo v, FormaPagamento f, int pont){
        this.cpf = cpf;
        this.nome = nome;
        this.veiculo = v;
        this.pagamento = f;
        this.pontuacaoMedia = pont;
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

    public int getPontuacaoMedia(){
        return pontuacaoMedia;
    }

    public void setPontuaçaoMedia(int media){
        this.pontuacaoMedia = media;
    }

    public void incrementaCorrida(){
        contaCorridas++;
    }

    public void infoPontuacao(int pontuacao){
        int nova_media = getPontuacaoMedia() + (pontuacao / contaCorridas);
        setPontuaçaoMedia(nova_media);
    }

    @Override
    public String toString() {
        return  "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", veiculo=(" + veiculo + ")" +
                ", pagamento=" + pagamento +
                ", pontuacaoMedia=" + pontuacaoMedia;
    }
}