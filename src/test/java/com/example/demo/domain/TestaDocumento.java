package com.example.demo.domain;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestaDocumento {
    @Rule
    public ExpectedException excecao = ExpectedException.none();

    @Test
    public void aoCriarDocumentoInformandoNumeroVazioLancarException() {
        excecao.expect(RuntimeException.class);
        excecao.expectMessage("Número de documento é obrigatório");
        new Documento("");
    }

    @Test
    public void aoCriarDocumentoInformandoNullLancarException() {
        excecao.expect(RuntimeException.class);
        excecao.expectMessage("Número de documento é obrigatório");
        new Documento(null);
    }

    @Test
    public void aoCriarDocumentoInformandoTextoLancarException() {
        excecao.expect(RuntimeException.class);
        excecao.expectMessage("Apenas números devem ser informados ao criar um documento");
        new Documento("abcdefg");
    }

    @Test
    public void aoCriaDocumentoInformandoCpfComMaisNumerosLancarException() {
        excecao.expect(RuntimeException.class);
        excecao.expectMessage("Não foi possível identificar se o número é um CNPJ ou CPF");
        final String CPFCom12Digitos = "123.123.456.789";
        new Documento(CPFCom12Digitos);
    }

    @Test
    public void aoCriarDocumentoInformandoCpfComMenosNumerosLancarException() {
        excecao.expect(RuntimeException.class);
        excecao.expectMessage("Não foi possível identificar se o número é um CNPJ ou CPF");
        final String CPFCom10Digitos = "123.123.456";
        new Documento(CPFCom10Digitos);
    }

    @Test
    public void aoCriarDocumentoInformandoCpfValidoRetornaTipoCPF() {
        final String CPF = "123.456.789-45";
        Documento documento = new Documento(CPF);
        Assert.assertEquals(documento.getTipo(), Documento.Tipo.CPF);
    }

    @Test
    public void aoCriarDocumentoInformandoCpfValidoRetornarNumeroSemValorDeMascara() {
        final String CPF = "123.456.789-45";
        Documento documento = new Documento(CPF);
        Assert.assertEquals(documento.getNumero().toString(), "12345678945");
    }

    @Test
    public void aoCriarDocumentoInformandoCpfSemMascaraRetornarTipoCPF() {
        final String CPFSemMascara = "12345678945";
        Documento documento = new Documento(CPFSemMascara);
        Assert.assertEquals(documento.getTipo(), Documento.Tipo.CPF);
    }

    @Test
    public void aoCriarDocumentoInformandoCpnjComMaisNumerosLancarException() {
        excecao.expect(RuntimeException.class);
        excecao.expectMessage("Não foi possível identificar se o número é um CNPJ ou CPF");
        final String CNPJCom15Digitos = "47.483.765/0001-933";
        new Documento(CNPJCom15Digitos);
    }

    @Test
    public void aoCriarDocumentoInformandoCnpjComMenosNumerosLancarException() {
        excecao.expect(RuntimeException.class);
        excecao.expectMessage("Não foi possível identificar se o número é um CNPJ ou CPF");
        final String CNPJCom13Digitos = "47.483.765/0001-9";
        new Documento(CNPJCom13Digitos);
    }

    @Test
    public void aoCriarDocumentoInformandoCnpjValidoRetornaTipoCNPJ() {
        final String CNPJ = "47.483.765/0001-93";
        Documento documento = new Documento(CNPJ);
        Assert.assertEquals(documento.getTipo(), Documento.Tipo.CNPJ);
    }

    @Test
    public void aoCriarDocumentoInformandoCnpjValidoRetornarNumeroSemValorDeMascara() {
        final String CNPJ = "47.483.765/0001-93";
        Documento documento = new Documento(CNPJ);
        Assert.assertEquals(documento.getNumero().toString(), "47483765000193");
    }

    @Test
    public void aoCriarDocumentoInformandoCnpjSemMascaraRetornarTipoCNPJ() {
        final String CNPJSemMascara = "47483765000193";
        Documento documento = new Documento(CNPJSemMascara);
        Assert.assertEquals(documento.getTipo(), Documento.Tipo.CNPJ);
    }
}
