package com.tecnicas_pucrs.entidades;

import com.tecnicas_pucrs.entidades.geometria.Ponto;
import com.tecnicas_pucrs.entidades.geometria.Reta;
import com.tecnicas_pucrs.entidades.geometria.SituacaoDaReta;

import java.util.List;
import java.util.stream.Collectors;

public class Roteiro {

    private Cidade cidade;
    private Bairro bairroOrigem;
    private Bairro bairroDestino;

    public Roteiro(Cidade cidade, Bairro bairroOrigem, Bairro bairroDestino) {
        this.cidade = cidade;
        this.bairroOrigem = bairroOrigem;
        this.bairroDestino = bairroDestino;
    }

    public List<Bairro> bairrosPercorridos(){
        return cidade
                .getListaDeBairros()
                .stream()
                .filter(b->b.getLimites().classifica(this.getRota())!= SituacaoDaReta.TODA_FORA)
                .collect(Collectors.toList());
    }

    public Reta getRota(){
        Ponto pOrig = bairroOrigem.getLimites().pontoCentral();
        Ponto pDest = bairroOrigem.getLimites().pontoCentral();
        return new Reta(pOrig,pDest);
    }

    @Override
    public String toString() {
        return bairroOrigem + ";" + bairroDestino ;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Bairro getBairroOrigem() {
        return bairroOrigem;
    }

    public Bairro getBairroDestino() {
        return bairroDestino;
    }
}
