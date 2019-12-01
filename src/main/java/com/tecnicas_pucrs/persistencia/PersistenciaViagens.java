package com.tecnicas_pucrs.persistencia;

import com.tecnicas_pucrs.entidades.*;
import com.tecnicas_pucrs.interfaces.repositorios.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaViagens {


    public static List<Viagem> carregaViagens() throws FileNotFoundException, URISyntaxException, IOException {

        List<Viagem> listaViagens = new ArrayList<>();

        try (
                Reader reader = new BufferedReader(new InputStreamReader(PersistenciaVeiculos.class.getResourceAsStream("/viagens.dat")));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            RepoBairros repoBairros = new RepoBairros();
            RepoCidades repoCidades = new RepoCidades();
            RepoMotoristas repoMotoristas = new RepoMotoristas();
            RepoPassageiros repoPassegeiros = new RepoPassageiros();

            for (CSVRecord csvRecord : records) {
                int id = Integer.parseInt(csvRecord.get("id"));
                String data = csvRecord.get("dataHora");
                String roteiro = csvRecord.get("roteiro");
                Motorista motorista = repoMotoristas.recuperaPorCPF(csvRecord.get("motorista"));
                Passageiro passageiro = repoPassegeiros.recuperaPorCPF(csvRecord.get("passageiro"));
                double custo = Double.parseDouble(csvRecord.get("custo"));
                String[] Lroteiros = roteiro.replace("[", "").replace("]", "").split(";");

                Roteiro roteirow = new Roteiro(repoCidades.recuperaPorNome("canoas"), repoBairros.recuperaPorNome(Lroteiros[0]), repoBairros.recuperaPorNome(Lroteiros[1]));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                Viagem viagem = new Viagem(id, LocalDateTime.parse(data, formatter),roteirow,motorista,passageiro,custo);
                listaViagens.add(viagem);
            }
        }

        return listaViagens;
    }
}
