import Models.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();
        Menu menu = new Menu();
        menu.exibir();
        System.out.println("\nDigite a opção: ");
        byte opc = scanner.nextByte();
        scanner.nextLine();

        switch (opc){
            case 1:
                System.out.println("\nNome do filme: ");
                    String nome = scanner.nextLine();
                System.out.println("\nDuração (em mintos) do filme: ");
                    double duracao = scanner.nextDouble();
                    scanner.nextLine();
                System.out.println("\nGênero do filme: ");
                    String genero = scanner.nextLine();
                Filme filme = new Filme(nome, duracao, genero);
                cinema.cadastrarFilme(filme);
            case 2:
                System.out.println("Filmes: ");
                cinema.sa


        }
    }
}