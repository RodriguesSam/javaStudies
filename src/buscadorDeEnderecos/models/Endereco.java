package buscadorDeEnderecos.models;

public class Endereco {
    private String cep, ddd;
    private String logradouro, complemento, bairro, localidade, uf, estado, regiao;


    public Endereco() {
//        this.cep = cep;
    }



    public void popularVariaveis(EnderecoViaCEP consulta){
        //popula as variaveis da classe com os resultados da consulta
        this.cep = consulta.cep();
        this.logradouro = consulta.logradouro();
        this.bairro = consulta.bairro();
        this.localidade = consulta.localidade();
        this.uf = consulta.uf();
        this.estado = consulta.estado();
        this.regiao = consulta.regiao();
        this.ddd = consulta.ddd();
    }

    public void recebeEnderecos() {}

    public void buscarPorEndereco(String endereco) {

    }

    @Override
    public String toString() {


        return "CEP: " + cep + "\nLogradouro: " + logradouro + "\nBairro: " + bairro + "\nLocalidade: " +
                localidade + "\nUF: " + uf + "\nEstado: " + estado + "\nRegião: " + regiao + "\nDDD: " + ddd;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}
