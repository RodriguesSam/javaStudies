package aula4;

import aula4.models.Veiculo;
import com.google.gson.Gson;

public class TesteVeiculo {
    public static void main(String[] args) {
        Veiculo uno = new Veiculo("Fiat", "UNO");

        uno.setCor("Cinza");
        uno.setPreco(30000);
        uno.setAnoDeFabricacao(2016);

        Gson gson = new Gson();

        String json =  gson.toJson(uno);
        System.out.println(json);
    }
}
