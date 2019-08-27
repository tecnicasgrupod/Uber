package com.tecnicas_pucrs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.tecnicas_pucrs.Motorista;
import com.tecnicas_pucrs.FormaPagamento;

public class PersistenciaMotoristas{

    private static final String CSV_FILE_PATH = "motoristas.dat";

    public static List<Motorista> carregaMotoristas() throws FileNotFoundException, URISyntaxException, IOException{

        List<Motorista> listaMotorista = new ArrayList<>();

        try (
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
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

                Veiculo veiculo_do_motorista = ControleDeVeiculos.getVeiculo(placa);

                Motorista motorista = new Motorista(cpf, nome, veiculo_do_motorista, enum_pagamento, pontuacaoMedia);
                listaMotorista.add(motorista);
            }
        }

        return listaMotorista;
    }

    public static boolean persisteMotoristas(List<Motorista> lst)throws URISyntaxException, IOException{
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("CPF", "Nome", "Veiculo", "Forma de Pagamento", "Pontuação Média"));
            for(Motorista m : lst){
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
}
