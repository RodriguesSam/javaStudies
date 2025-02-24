package aula2;

import com.sun.jdi.IntegerValue;

public class Pessoa {
    private String nome, cidade;
    private int idade;

    public Pessoa(Person person) {
        this.nome = person.name();
        this.cidade = person.city();
        this.idade = Integer.valueOf(person.age());
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade + "\nCidade: " + cidade;
    }
}
