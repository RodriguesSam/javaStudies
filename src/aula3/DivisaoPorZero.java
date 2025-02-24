package aula3;

import java.util.Scanner;

public class DivisaoPorZero {
    public static void main(String[] args) {
        int num1, num2;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite um número inteiro:");
        num1 = input.nextInt();

        System.out.println("Digite outro número inteiro, que seja diferente de 0:");
        num2 = input.nextInt();

        try {
            int divisao = num1/num2;
            System.out.println(divisao);
        } catch (ArithmeticException e) {
            System.out.println("Divisão por zero. Operação cancelada.");
        }
    }
}
