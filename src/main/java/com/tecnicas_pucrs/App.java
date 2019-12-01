package com.tecnicas_pucrs;

import com.tecnicas_pucrs.interfaces.repositorios.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) throws IOException, URISyntaxException {

        RepoVeiculos repoVeiculos = new RepoVeiculos();
        RepoMotoristas repoMotoristas = new RepoMotoristas();
        RepoPassageiros repoPassageiros = new RepoPassageiros();
        RepoBairros repoBairros = new RepoBairros();
        RepoCidades repoCidades = new RepoCidades();
        RepoViagens repoViagens = new RepoViagens();

        System.out.println("VEICULOS =>" + repoVeiculos.getVeiculos());
        System.out.println("MOTORISTAS =>" + repoMotoristas.getMotoristas());
        System.out.println("PASSAGEIROS =>" + repoPassageiros.getPassageiros());
        System.out.println("BAIRROS =>" + repoBairros.getBairros());
        System.out.println("CIDADES =>" + repoCidades.getCidades());
        System.out.println("VIAGENS =>" + repoViagens.getViagens());

    }
}
