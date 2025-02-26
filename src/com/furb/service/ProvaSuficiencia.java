package com.furb.service;

import com.furb.exception.EArquivoOrigemIncorreto;
import com.furb.model.Atleta;
import com.furb.model.Endereco;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProvaSuficiencia {

    public ProvaSuficiencia(String arqOrigem, String arqDestino) throws IOException {
        serializar(arqOrigem, arqDestino);
    }

    public static void serializar(String arqOrigem, String arqDestino) throws IOException {
        List<Atleta> atletas = new ArrayList<>();
        BufferedReader lerArq;
        String linha;

        try {
            FileReader arq = new FileReader(arqOrigem);
            lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();
        } catch (IOException ex) {
            throw new EArquivoOrigemIncorreto("Erro: " + ex.getMessage());
        }

        while (linha != null) {
            String[] dadosSeparados = linha.split(",");

            String nome = dadosSeparados[0].trim();
            String cpf = dadosSeparados[1].trim();
            Float altura = Float.parseFloat(dadosSeparados[2].trim());
            Float peso = Float.parseFloat(dadosSeparados[3].trim());
            Endereco endereco = new Endereco();
            endereco.setRua(dadosSeparados[4].trim());
            endereco.setNumero(dadosSeparados[5].trim());
            endereco.setComplemento(dadosSeparados[6].trim());
            endereco.setCEP(dadosSeparados[7].trim());
            endereco.setCidade(dadosSeparados[8].trim());
            endereco.setEstado(dadosSeparados[9].trim());

            if(atletas.stream().filter(atleta -> atleta.getCpf().equals(cpf)).toList().isEmpty()) {
                Atleta atleta = new Atleta(nome, cpf, altura, peso, endereco);
                atletas.add(atleta);
            } else {
                throw new RuntimeException("o CPF precisa ser único por pessoa!");
            }
            linha = lerArq.readLine(); // lê da segunda até a última linha
        }

        try {
            FileOutputStream fileOutput = new FileOutputStream(arqDestino);

            atletas.forEach(atleta -> {
                char caracteres[] = atleta.getNome().toCharArray();
                for (int i = 0; i < atleta.getNome().length(); i++) {
                    try {
                        fileOutput.write(caracteres[i]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            fileOutput.close();

        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo destino: " + e.getMessage());
        }
    }

}
