package aula3;

import aula3.exception.SenhaInvalidaException;

import java.util.Scanner;

public class TesteSenha {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite uma senha com ao menos 8 caracteres:");
         try {
             Senha password = new Senha(input.nextLine());
             System.out.println("Senha definida com sucesso!");
         } catch (SenhaInvalidaException e) {
             System.out.println(e.getMessage());
         }
    }
}
