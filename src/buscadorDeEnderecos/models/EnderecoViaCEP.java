package buscadorDeEnderecos.models;

public record EnderecoViaCEP(String cep, String logradouro, String bairro, String localidade, String uf, String estado, String regiao, String ddd) {
}
