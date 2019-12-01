package com.tecnicas_pucrs.persistencia;


import com.tecnicas_pucrs.entidades.FormaPagamento;
import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Passageiro;
import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.interfaces.repositorios.RepoVeiculos;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaPassageiros {

    private static final String CSV_FILE_PATH = "passageiros.dat";

    public static List<Passageiro> carregaPassageiros() throws FileNotFoundException, URISyntaxException, IOException {

        List<Passageiro> listaPassageiros = new ArrayList<>();

        try (
                Reader reader = new BufferedReader(new InputStreamReader(PersistenciaVeiculos.class.getResourceAsStream("/passageiros.dat")));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord csvRecord : records) {
                String cpf = csvRecord.get("cpf");
                String nome = csvRecord.get("nome");
                String cartao = csvRecord.get("nroCartao");
                String pagamento = csvRecord.get("formaPagamento");
                int pontuacaoMedia = Integer.parseInt(csvRecord.get("pontuacaoMedia"));

                FormaPagamento enum_pagamento = FormaPagamento.CARTAO;
                if (pagamento.equals("DINHEIRO")) enum_pagamento = FormaPagamento.DINHEIRO;
                if (pagamento.equals("CARTAO")) enum_pagamento = FormaPagamento.CARTAO;
                if (pagamento.equals("TODAS")) enum_pagamento = FormaPagamento.TODAS;

                Passageiro passageiro = new Passageiro(nome, cpf, enum_pagamento, cartao, pontuacaoMedia);
                listaPassageiros.add(passageiro);
            }
        }

        return listaPassageiros;
    }

    public static boolean persistePassageiros(List<Passageiro> lst) throws URISyntaxException, IOException {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("CPF", "Nome", "Veiculo", "Forma de Pagamento", "Pontuação Média"));
            for (Passageiro m : lst) {
                csvPrinter.printRecord(m.getCPF(), m.getNome(), m.getFormaPagamento(), m.getNroCartao(), m.getPontuacaoMedia());
            }
            csvPrinter.flush();
            csvPrinter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
