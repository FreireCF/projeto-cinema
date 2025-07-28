import Models.*;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();
        Assento assento = new Assento('A', 1);
        Menu menu = new Menu();
        byte opc;

        do {
            menu.exibir();
            System.out.println("\nDigite a opção: ");
            opc = scanner.nextByte();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("\nTítulo do filme: ");
                        String titulo = scanner.nextLine();

                    System.out.println("\nDuração (em mintos) do filme: ");
                        double duracao = scanner.nextDouble();
                        scanner.nextLine();

                    System.out.println("\nGênero do filme: ");
                        String genero = scanner.nextLine();

                    Filme f = new Filme(titulo, duracao, genero);
                    cinema.adicionarFilme(f);
                    break;
                case 2:
                    System.out.println("\nNúmero da sala: ");
                        int numSala = scanner.nextInt();
                        scanner.nextLine();
                        Sala s = new Sala(numSala);
                        cinema.cadastrarSala(s);
                        break;
                case 3:
                    List<Filme> naoAlocados = cinema.exibirFilmesNaoAlocados();

                    if(naoAlocados.isEmpty()){
                        System.out.println("\nTodos os filmes já estão alocados");
                    } else {
                        System.out.println("\nFilmes não alocados: ");
                        for(Filme fi : naoAlocados){
                            System.out.println("\n"+fi.getTitulo());
                        }
                    }

                    System.out.println("\nDigite o nome do filme que deseja alocar: ");
                        String nomeF = scanner.nextLine();

                    System.out.println("\nSalas sem filme: ");
                        cinema.exibirSalasSemFilme();

                    System.out.println("\nDigite o número sala deseja alocar "+nomeF);
                        int auxNum = scanner.nextInt();
                        scanner.nextLine();

                    cinema.alocarFilmeEmSala(auxNum, nomeF);
                    break;
                case 4:
                    System.out.println("\nSalas cadastradas: ");
                    cinema.exibirSalas();
                    System.out.println(("\nDigite o número da sala que deseja informações: "));
                        int num = scanner.nextInt();
                        scanner.nextLine();
                    cinema.relatorioDaSala(num);
                    break;
            }
        } while(opc!=0);
    }
}