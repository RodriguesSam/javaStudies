package buscadorDeEnderecos.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consulta {

    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    

    public void tipoDePesquisa() throws IOException, InterruptedException {
        // Usuário escolhe se deseja consultar por CEP ou por endereco.
        List<String> atributos = new ArrayList<>();
        int escolhaTipoDeConsulta;
        Scanner input = new Scanner(System.in);

        System.out.println("Selecione uma opção:");

        do {
            System.out.printf("""
                    
                    1. Consulta por CEP
                    2. Consulta por endereço
                    3. Sair
                    
                    """);

            escolhaTipoDeConsulta = input.nextInt();
            input.nextLine();

            if (escolhaTipoDeConsulta == 3) {
                System.out.println("Programa encerrado. Até logo!");
                break;
            }

            if (escolhaTipoDeConsulta == 1) {
                System.out.println("Digite o CEP:");
                atributos.add(input.nextLine());


            } else if (escolhaTipoDeConsulta == 2) {
                System.out.println("Digite a UF:");
                atributos.add(input.nextLine());

                System.out.println("Digite a cidade:");
                atributos.add(input.nextLine());

                System.out.println("Digite o logradouro:");
                atributos.add(input.nextLine());


            } else {
                System.out.println("Selecione uma opção válida!");
            }
            consultaPorCep(atributos);
            //resolver questão de limpar a lista após primeiro processamento!

        } while (escolhaTipoDeConsulta != 3);

    }

    public void consultaPorCep(List<String> partesDoEndereco) throws IOException, InterruptedException {
        String linkConsulta = "https://viacep.com.br/ws/";

        for(String parte : partesDoEndereco) {
            linkConsulta += parte + "/";
        }
        linkConsulta += "json/";
        linkConsulta = linkConsulta.replace(" ", "%20");
        //System.out.println(linkConsulta);


        String httpResponse = pegaJson(linkConsulta);
        criaObjEndereco(httpResponse);
//        imprimirConsulta(httpResponse);
    }

    public List<EnderecoViaCEP> criaObjEndereco(String httpResponse) {
        List<EnderecoViaCEP> listaDeEnderecos = new ArrayList<>();

        if(httpResponse.startsWith("[")) {
            EnderecoViaCEP[] arrayEnderecosJson = gson.fromJson(httpResponse, EnderecoViaCEP[].class);

            if(arrayEnderecosJson.length > 0) {
                for(EnderecoViaCEP enderecoJson : arrayEnderecosJson){
                    listaDeEnderecos.add(enderecoJson);
                    System.out.println(enderecoJson);
                }
            } else {
                System.out.println("A pesquisa não retornou resultados..");
            }

        } else {
            EnderecoViaCEP enderecoJson = gson.fromJson(httpResponse, EnderecoViaCEP.class);
            listaDeEnderecos.add(enderecoJson);
        }
        //System.out.println(listaDeEnderecos);



        return listaDeEnderecos;
    }


    public void consultaPorEndereco(String[] endereco){ }

    public String pegaJson(String link) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public void imprimirConsulta(String consulta) throws IOException {
        FileWriter escrever = new FileWriter("Consulta.json");
        EnderecoViaCEP endereco = gson.fromJson(consulta, EnderecoViaCEP.class);
        escrever.write(String.valueOf(endereco));
        escrever.close();
    }
}
