/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintaxeBasica;

import java.util.Scanner;

public class Leitura_Scanner {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String nome; int idade;
        System.out.print("Escreva seu nome: ");
        nome = read.nextLine();
        System.out.print("Escreva sua idade: ");
        idade = read.nextInt();
        System.out.print(nome + 
                 " voce tem " + idade +" anos");
    }
}