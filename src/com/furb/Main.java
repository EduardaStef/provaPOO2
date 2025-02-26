package com.furb;

import com.furb.service.ProvaSuficiencia;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a localização do arquivo origem:");
        String arquivoOrg = teclado.next();

        System.out.println("Informe a localizacao do arquivo destino:");
        String arquivoDest = teclado.next();

        new ProvaSuficiencia(arquivoOrg, arquivoDest);
    }
}

