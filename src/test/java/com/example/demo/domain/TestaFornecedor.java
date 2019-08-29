package com.example.demo.domain;

import org.junit.Test;

public class TestaFornecedor {
    @Test
    public void criandoUmFornecedorValido() {
        String CPF = "123.123.123-41";
        Documento documentoCPF = new Documento(CPF);
        new Fornecedor(Fornecedor.Tipo.FISICO, "Thiago de Melo Fontana", documentoCPF);
    }

    @Test
    public void limpadorDeNumero() {
        String cpf = "348.916.918-24";
        System.out.println(cpf.replaceAll("", ""));

        String nome = "Thiago-123.1 / 00";
        System.out.println(nome.replaceAll("\\D", ""));
    }
}
