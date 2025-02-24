package aula3;

import aula3.exception.SenhaInvalidaException;

public class Senha {
    String senha;

    public Senha(String senha){
        if (senha.length() < 8) {
            throw new SenhaInvalidaException("A senha digitada possui menos de 8 caracteres. Tente novamente");
        } else {
            this.senha = senha;
        }
    }
}
