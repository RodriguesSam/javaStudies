package estruturasDeDados;

/**************************************************************************************************************
 * Samuel Rodrigues
 *
 * Estruturas de dados: computação na prática com Java
 *
 * Exercício simples para compreender os princípios de estruturas de dados e Arrays e como aplicá-los com a
 * orientação a objetos.
 *
 * Referência: https://www.alura.com.br/artigos/estrutura-dados-computacao-na-pratica-com-java
 *************************************************************************************************************/

import estruturasDeDados.models.Aluno;
import estruturasDeDados.models.Vetor;

public class Main {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("George");
        Aluno a2 = new Aluno("Julia");
        Aluno a3 = new Aluno("Marcos");
        Aluno a4 = new Aluno("Priscila");

        Vetor lista = new Vetor();

        lista.adicionaAluno(a1);
        lista.adicionaAluno(a2);
        lista.adicionaAluno(a3);
        lista.adicionaAluno(a4);

        lista.imprimirItens();

        Aluno a5 = new Aluno("José");
        System.out.println("\nAdicionar José na posição 2:");
        lista.adicionaNoMeio(2, a5);
        lista.imprimirItens();

        System.out.println("\nRemover aluno da posição 3 e rearranjar as posições dos outros itens:");
        lista.removeAluno(3);
        lista.imprimirItens();

        //laco para adicionar 300 alunos e testar o metodo garanteEspaco
        for (int i = 0; i < 300; i++) {
            Aluno y = new Aluno("Joao" + i);
            lista.adicionaAluno(y);
        }
        System.out.println(lista);
    }
}
