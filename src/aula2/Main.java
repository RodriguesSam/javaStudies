package aula2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                "Name" : "Samuel",
                "Age" : 23,
                "City" : "Brasília"
                }
                """;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        Person person = gson.fromJson(json, Person.class);
        System.out.println("Classe record:");
        System.out.println(person + "\n");

        System.out.println("Classe normal, configurada para receber as informações da classe record:");
        Pessoa pessoa = new Pessoa(person);
        System.out.println(pessoa);
        System.out.println("\n");

        /*************************************************************/

        String jsonLivro = "{\"titulo\":\"Les Miserábles\",\"autor\":\"Victor Hugo\",\"editora\":{\"nome\":\"Martin Claret\",\"cidade\":\"São Paulo\"}}";

        Gson gson2 = new Gson();
        Livro book = gson2.fromJson(jsonLivro, Livro.class);

        System.out.println("Impressão do objeto após importação do json:");
        System.out.println(book);
    }
}
