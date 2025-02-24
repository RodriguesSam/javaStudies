package aula4.models;

import java.io.FileWriter;
import java.io.IOException;

public class EscreverMensagem {
    public static void main(String[] args) throws IOException {
        String mensagem = "Conteúdo a ser gravado no arquivo hehe";

        try (FileWriter escrita = new FileWriter("arquivo.txt")) {
            escrita.write("Conteúdo a ser gravado no arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
