package com.tecnicas_pucrs.persistencia;

import com.tecnicas_pucrs.entidades.*;
import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoBairros;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCidades {

    public static List<Cidade> carregaCidades() throws URISyntaxException, IOException {

        List<Cidade> listaCidades = new ArrayList<>();

        try (
                Reader reader = new BufferedReader(new InputStreamReader(PersistenciaVeiculos.class.getResourceAsStream("/cidades.dat")));
        ) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord csvRecord : records) {
                String nome = csvRecord.get("nome");
                String bairros = csvRecord.get("bairros");

                String[] Lbairros = bairros.replace("[", "").replace("]", "").split(";");

                List<Bairro> listaDeBairro = new ArrayList<>();
                RepoBairros repoBairros = new RepoBairros();

                for (String b : Lbairros) {
                    listaDeBairro.add(repoBairros.recuperarPorNome(b));
                }

                Cidade cidade = new Cidade(nome, listaDeBairro);
                listaCidades.add(cidade);
            }
        }

        return listaCidades;
    }
}
