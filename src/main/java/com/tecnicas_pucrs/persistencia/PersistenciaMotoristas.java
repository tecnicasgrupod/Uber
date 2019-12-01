package com.tecnicas_pucrs.persistencia;


import com.tecnicas_pucrs.entidades.FormaPagamento;
import com.tecnicas_pucrs.entidades.Motorista;
import com.tecnicas_pucrs.entidades.Veiculo;
import com.tecnicas_pucrs.casos_de_uso.repositorios.RepoVeiculos;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaMotoristas {

    public static List<Motorista> carregaMotoristas() throws URISyntaxException, IOException {

        List<Motorista> listaMotorista = new ArrayList<>();
        RepoVeiculos repoVeiculos = new RepoVeiculos();

        try (
                Reader reader = new BufferedReader(new InputStreamReader(PersistenciaVeiculos.class.getResourceAsStream("/motoristas.dat")));
        ) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord csvRecord : records) {
                String cpf = csvRecord.get("cpf");
                String nome = csvRecord.get("nome");
                String placa = csvRecord.get("veiculo");
                String pagamento = csvRecord.get("pagamento");
                int pontuacaoMedia = Integer.parseInt(csvRecord.get("pontuacaoMedia"));

                FormaPagamento enum_pagamento = FormaPagamento.CARTAO;
                if (pagamento.equals("DINHEIRO")) enum_pagamento = FormaPagamento.DINHEIRO;
                if (pagamento.equals("CARTAO")) enum_pagamento = FormaPagamento.CARTAO;
                if (pagamento.equals("TODAS")) enum_pagamento = FormaPagamento.TODAS;

                Veiculo veiculo_do_motorista = repoVeiculos.recuperarPorPlaca(placa);

                Motorista motorista = new Motorista(cpf, nome, veiculo_do_motorista, enum_pagamento, pontuacaoMedia);
                listaMotorista.add(motorista);
            }
        }

        return listaMotorista;
    }

    /**
    public static boolean persisteMotoristas(List<Motorista> lst) throws URISyntaxException, IOException {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("CPF", "Nome", "Veiculo", "Forma de Pagamento", "Pontuação Média"));
            for (Motorista m : lst) {
                csvPrinter.printRecord(m.getCPF(), m.getNome(), m.getVeiculo(), m.getFormaPagamento(), m.getPontuacaoMedia());
            }
            csvPrinter.flush();
            csvPrinter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
     **/
}
