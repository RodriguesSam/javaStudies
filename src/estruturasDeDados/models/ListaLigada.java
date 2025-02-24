package estruturasDeDados.models;

public class ListaLigada {

    //como a lista inicia vazia, a primeira celula inicia com valor null
    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos = 0;

    public void adicionaNoComeco(Object elemento) {
        /* Para o estudo da lista ligada, foi feito inicialmente o seguinte código*/
//
//        Celula nova = new Celula(elemento, primeira);
//        this.primeira = nova;
//
//        //se a lista estiver vazia, o primeiro elemento tambem é o último
//        if(this.totalDeElementos == 0) {
//            this.ultima = this.primeira;
//        }
//
//        this.totalDeElementos++;


        /* Para a lista duplamente ligada, e após implementar outro Constructor, faremos o seguinte código:*/

        if(this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, (Celula) elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }

    public void adicionaNoFinal(Object elemento) {

        if(this.totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    public void adicionaNoMeio(int posicao, Object elemento) {

        if(posicao == 0){
            adicionaNoComeco(elemento);
        } else if (posicao == totalDeElementos) {
            adicionaNoFinal(elemento);
        } else {
            Celula anterior = (Celula) this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProximo();

            Celula nova = new Celula(anterior.getProximo(), (Celula) elemento);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    public Object pegaCelula(int posicao) {

        if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe!");
        }

        Celula atual = primeira;

        for(int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual; }

    public Object pega(int posicao) {
        Celula objeto = (Celula) pegaCelula(posicao);
        return objeto.getElemento();
    }

    public void remove(int posicao) {    }

    public void removeDoComeco() {
        if(this.totalDeElementos == 0) {
            throw new IllegalArgumentException("Lista vazia");
        }

        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;

        if(this.totalDeElementos == 0){
            this.ultima = null;
        }
    }

    public void removeDoFim() {
        if(this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProximo(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    public int tamanho() {
        return this.totalDeElementos; }

    public boolean contem(Object o) { return false; }

    @Override
    public String toString() {

        if(this.totalDeElementos == 0) {
            return "[]";
        }

        Celula atual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for(int i = 0; i < totalDeElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

}
