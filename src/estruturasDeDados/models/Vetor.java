package estruturasDeDados.models;

import java.util.Arrays;

public class Vetor {
    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adicionaAluno(Aluno aluno) {
        this.garanteEspaco();
        //recebe um aluno
        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
    }

    public void adicionaNoMeio(int posicao, Aluno aluno){
        this.garanteEspaco();
        if(!posicaoValida(posicao)){
            throw new  IllegalArgumentException("Posição inválida!");
        }

        for(int i = totalDeAlunos - 1; i >= posicao; i--) {
            alunos[i + 1] = alunos[i];
        }
        alunos[posicao] = aluno;
        totalDeAlunos++;

    }

    public Aluno pegaAluno(int posicao) {
        //recebe uma posição e devolve o aluno

        try {
            if(alunos[posicao] != null) {
                return alunos[posicao];
            } else {
                throw new IllegalArgumentException("Nenhum aluno nesta posição");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida!");
        }
    }

    public void removeAluno(int posicao) {
        //remove pela posição, mas não reajusta os itens do Array
        if(!posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida!");
        }

        for(int i = posicao; i < this.totalDeAlunos; i++){
            alunos[i] = alunos[i+1];
        }
        totalDeAlunos--;
    }

    public boolean contemAluno(Aluno aluno) {
        //descobre se um aluno está ou não na lista
        for (Aluno value : alunos) {
            if (aluno.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void imprimirItens() {
        int posicao = 0;
        for (int i = 0; i < alunos.length; i++) {
            if(alunos[i] != null) {
                System.out.println("Posição " + posicao + ": " + alunos[i].getNome());
            }
            posicao++;
        }
    }

    public int tamanho() {
        //devolve a quantidade de alunos
        return totalDeAlunos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= totalDeAlunos;
    }

    private void garanteEspaco() {
        //cria um array maior para acomodar mais itens
        if(totalDeAlunos == alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for(int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];
            }
            this.alunos = novoArray;
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(alunos);
    }
}
