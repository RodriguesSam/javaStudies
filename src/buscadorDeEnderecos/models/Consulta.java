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

//    public String consultarViaCEP() throws IOException, InterruptedException {
//        String link = "";
//        int escolha = escolhaUsuario();
//
//        if(escolha == 1) {
//            link = "https://viacep.com.br/ws/" + cep + "/json/";
//        } else {
//            link = String.format("https://viacep.com.br/ws/%s/%s/%s/json/",uf,localidade,logradouro).replace(" ","%20");
//        }
//
//        //requisição http:
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(link))
//                .build();
//        HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());
//
//        String jsonResposta = response.body();
//
//        //Caso o retorno seja uma lista de endereços, a referência criada deve ser um array
//        if(jsonResposta.startsWith("[")) {
//            EnderecoViaCEP[] respostaCEPArray = gson.fromJson(jsonResposta, EnderecoViaCEP[].class);
//
//            if (respostaCEPArray.length > 0) {
//                for(int i = 0; i < respostaCEPArray.length; i++){
////                    popularVariaveis(respostaCEPArray[]);
//                    imprimirConsultaArray(respostaCEPArray);
//                }
//                FileWriter escrever = new FileWriter("Consulta.txt");
//                escrever.write(Arrays.toString(respostaCEPArray));
//                escrever.close();
//
//            } else {
//                System.out.println("Nenhum endereço encontrado!");
//            }
//
//        } else {
//            EnderecoViaCEP respostaCEP = gson.fromJson(response.body(), EnderecoViaCEP.class);
//            popularVariaveis(respostaCEP);
//            imprimirConsultaArray(respostaCEP);
//        }
//
//        return this.toString();
//    }

    public void tipoDePesquisa() throws IOException, InterruptedException {
        // Usuário escolhe se deseja consultar por CEP ou por endereco.

        int escolhaTipoDeConsulta = 0;
        List<String> atributos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Selecione uma opção:");

        while(escolhaTipoDeConsulta != 3) {

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
                break;

            } else if (escolhaTipoDeConsulta == 2) {
                System.out.println("Digite a UF:");
                atributos.add(input.nextLine());

                System.out.println("Digite a cidade:");
                atributos.add(input.nextLine());

                System.out.println("Digite o logradouro:");
                atributos.add(input.nextLine());
                break;

            } else {
                System.out.println("Selecione uma opção válida!");
            }
        }

        consultaPorCep(atributos);
    }

    public void consultaPorCep(List<String> partesDoEndereco) throws IOException, InterruptedException {
        String linkConsulta = "https://viacep.com.br/ws/";

        for(String parte : partesDoEndereco) {
            linkConsulta += parte + "/";
        }
        linkConsulta += "json/";
        System.out.println(linkConsulta);


        String jsonResponse = pegaJson(linkConsulta);
        imprimirConsultaArray(jsonResponse);
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

    public void imprimirConsultaArray(String consulta) throws IOException {
        FileWriter escrever = new FileWriter("Consulta.json");
        EnderecoViaCEP endereco = gson.fromJson(consulta, EnderecoViaCEP.class);
        escrever.write(String.valueOf(endereco));
        escrever.close();
    }
}
