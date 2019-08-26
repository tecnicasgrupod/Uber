package com.tecnicas_pucrs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import java.io.BufferedWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.tecnicas_pucrs.Passageiro;

public class PersistenciaPassageiros{

    public static List<Passageiro> carregaPassageiros() throws URISyntaxException, FileNotFoundException, IOException{
        
        List<Passageiro> listPassageiros = new ArrayList<>();
        URI csv_file_path = PersistenciaVeiculos.class.getResource("/passageiros.dat").toURI();

        try (
            Reader reader = Files.newBufferedReader(Paths.get(csv_file_path));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord csvRecord : records) {
                String nome = csvRecord.get("nome");
                String cpf = csvRecord.get("cpf");
                String formaPagamento = csvRecord.get("formaPagamento");
                String nroCartao = csvRecord.get("nroCartao");
                String pontuacaoMedia = csvRecord.get("pontuacaoMedia");

                FormaPagamento form = FormaPagamento.CARTAO;
                if (formaPagamento.equals("DINHEIRO")) form = FormaPagamento.DINHEIRO;
                if (formaPagamento.equals("CARTAO")) form = FormaPagamento.CARTAO;
                if (formaPagamento.equals("TODAS")) form = FormaPagamento.TODAS;
                
                Passageiro passageiro = new Passageiro(nome, cpf, form, nroCartao, Integer.parseInt(pontuacaoMedia));
                listPassageiros.add(passageiro);
            }
        }
        
        return listPassageiros;
    }

    public static boolean persistePassageiros(List<Passageiro> lst) throws URISyntaxException, IOException{

        URI csv_file_path = PersistenciaVeiculos.class.getResource("/passageiros.dat").toURI();

        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(csv_file_path));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("nome", "cpf", "formaPagamento", "nroCartao", "pontuacaoMedia"));
            for(Passageiro p : lst){
                csvPrinter.printRecord(p.getNome(), p.getCPF(), p.getFormaPagamento(), p.getNroCartao(), p.getPontuacaoMedia());
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