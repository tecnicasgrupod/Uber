package com.tecnicas_pucrs.casos_de_uso.politicas;

import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoBairros;
import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoCidades;
import com.tecnicas_pucrs.entidades.Bairro;
import com.tecnicas_pucrs.entidades.CategoriaVeiculo;
import com.tecnicas_pucrs.entidades.Cidade;
import com.tecnicas_pucrs.entidades.Roteiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoCustoTest {

    private CalculoCustoViagem calculoCustoViagem= new CalculoCustoViagem(new PrecoIntegro());;
    private RepoBairros rb = RepoBairros.getInstance();
    private RepoCidades rc = RepoCidades.getInstance();

    /*@BeforeEach
    public void setup(){

    }*/

    @DisplayName("Calcula custo de Viagens com PrecoIntegro")
    @ParameterizedTest
    @CsvSource({"canoas, guajuvira, sapo, SIMPLES, 30",
            "canoas, sapo, guajuvira, NORMAL, 33"
    })
    public void getCustoTestIntegro(String cidade, String bairroOrigem, String bairroDestino, CategoriaVeiculo cat, double respCusto){
        calculoCustoViagem.setPolitica(new PrecoIntegro());
        Cidade c = rc.recuperarPorNome(cidade);
        Bairro bo = rb.recuperarPorNome(bairroOrigem);
        Bairro bd = rb.recuperarPorNome(bairroDestino);
        Roteiro r = new Roteiro(c, bo, bd);
        double observed = calculoCustoViagem.getCusto(r, cat);
        assertEquals(respCusto, observed);
    }

    @DisplayName("Calcula custo de Viagens com DescontoNatal")
    @ParameterizedTest
    @CsvSource({"canoas, guajuvira, sapo, SIMPLES, 25",
            "canoas, sapo, guajuvira, NORMAL, 28"
    })
    public void getCustoTestNatal(String cidade, String bairroOrigem, String bairroDestino, CategoriaVeiculo cat, double respCusto){
        calculoCustoViagem.setPolitica(new DescontoNatal());
        Cidade c = rc.recuperarPorNome(cidade);
        Bairro bo = rb.recuperarPorNome(bairroOrigem);
        Bairro bd = rb.recuperarPorNome(bairroDestino);
        Roteiro r = new Roteiro(c, bo, bd);
        double observed = calculoCustoViagem.getCusto(r, cat);
        assertEquals(respCusto, observed);
    }


}
