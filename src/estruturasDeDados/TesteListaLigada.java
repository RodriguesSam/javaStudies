package estruturasDeDados;

import estruturasDeDados.models.ListaLigada;

import java.util.LinkedList;

public class TesteListaLigada {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        System.out.println(lista);
        lista.adicionaNoComeco("Marius");
        System.out.println(lista);
        lista.adicionaNoComeco("Eponine");
        System.out.println(lista);
        lista.adicionaNoComeco("Fantine");
        System.out.println(lista);

        System.out.println("\nAdicionando item no final:");
        lista.adicionaNoFinal("Valjean");
        System.out.println(lista);

        System.out.println("\nAdicionando item na posição 3:");
        lista.adicionaNoMeio(3,"Javert");
        System.out.println(lista);

        System.out.println("\nPega item da posição 2:");
        Object x = lista.pega(2);
        System.out.println(x);

        //Lista duplamente ligada

        System.out.println("Removendo um elemento do fim:");
        lista.removeDoFim();
        System.out.println(lista);


    }
}
