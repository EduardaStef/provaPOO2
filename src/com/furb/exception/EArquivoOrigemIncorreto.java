package com.furb.exception;

import java.io.IOException;

public class EArquivoOrigemIncorreto extends IOException {
    public EArquivoOrigemIncorreto(String mensagem) {
        super(mensagem);
    }
}
