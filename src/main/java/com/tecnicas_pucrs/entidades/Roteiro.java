package com.tecnicas_pucrs.entidades;

public class Roteiro {

    private Cidade cidade;
    private  Bairro bairroOrigem;
    private  Bairro bairroDestino;

    public Roteiro(Cidade cidade, Bairro bairroOrigem, Bairro bairroDestino) {
        this.cidade = cidade;
        this.bairroOrigem = bairroOrigem;
        this.bairroDestino = bairroDestino;
    }

    @Override
    public String toString() {
        return "Roteiro{" +
                "cidade=" + cidade +
                ", bairroOrigem=" + bairroOrigem +
                ", bairroDestino=" + bairroDestino +
                '}';
    }
}
