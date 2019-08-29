package com.example.demo.domain;

public class Fornecedor {
    private Long id;
    private Tipo tipoDeFornecedor;
    private String nome;
    private Documento documento;
    private Endereco endereco;

    public Fornecedor(Tipo tipoDeFornecedor, String nome, Documento documento) {
        this.tipoDeFornecedor = tipoDeFornecedor;
        this.nome = nome;
        this.documento = documento;
    }

    public void atualizaEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    enum Tipo {
        JURIDICO, FISICO, ESTRANGEIRO
    }
}
