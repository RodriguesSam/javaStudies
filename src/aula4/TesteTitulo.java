package aula4;

import aula4.models.Titulo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TesteTitulo {
    public static void main(String[] args) {
        Titulo title = new Titulo();

        title.setGenero("Horror");
        title.setNome("Hereditário");
        title.setAnoDeLancamento(2021);
        title.setIncluidoNoPlano(true);
        title.setDuracaoEmMinutos(120);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(title);

        System.out.println(json);
    }
}
