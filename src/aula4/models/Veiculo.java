package aula4.models;

public class Veiculo {
    private String modelo, fabricante, cor;
    private int anoDeFabricacao;
    private double preco;

    public Veiculo(String fabricante, String modelo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
