package com.example.demo.domain;

public class Documento {
    private Long numero;
    private Tipo tipo;

    public Documento(String CPF_CNPJ) {
        if (CPF_CNPJ == null || CPF_CNPJ == "")
            throw new RuntimeException("Número de documento é obrigatório");

        String numeroSemPontuacao = CPF_CNPJ.replaceAll("[^0-9]", "");
        if (!numeroSemPontuacao.matches("[0-9]+"))
            throw new RuntimeException("Apenas números devem ser informados ao criar um documento");

        if (numeroSemPontuacao.length() != 11 && numeroSemPontuacao.length() != 14)
            throw new RuntimeException("Não foi possível identificar se o número é um CNPJ ou CPF");

        if (numeroSemPontuacao.length() == 11)
            this.tipo = Tipo.CPF;
        else
            this.tipo = Tipo.CNPJ;

        this.numero = Long.parseLong(numeroSemPontuacao);
    }

    public Long getNumero() {
        return numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    enum Tipo {
        CNPJ, CPF
    }
}
