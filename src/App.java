import Models.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();
        Menu menu = new Menu();
        byte opc = -1;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        do {
            menu.exibir();
            try {
                System.out.println("\nDigite a opção: ");
                opc = scanner.nextByte();
                scanner.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("\nTítulo do filme: ");
                        String titulo = scanner.nextLine();

                        System.out.println("\nDuração (em minutos) do filme: ");
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

                        if (naoAlocados.isEmpty()) {
                            System.out.println("\nTodos os filmes já estão alocados");
                        } else {
                            System.out.println("\nFilmes não alocados: ");
                            for (Filme fi : naoAlocados) {
                                System.out.println("\n" + fi.getTitulo());
                            }
                        }

                        System.out.println("\nDigite o nome do filme que deseja alocar: ");
                        String nomeF = scanner.nextLine();

                        System.out.println("\nSalas sem filme: ");
                        cinema.exibirSalasSemFilme();

                        System.out.println("\nDigite o número da sala para alocar " + nomeF + ":");
                        int auxNum = scanner.nextInt();
                        scanner.nextLine();

                        cinema.alocarFilmeEmSala(auxNum, nomeF);
                        break;

                    case 4:
                        System.out.println("\nSalas cadastradas: ");
                        cinema.exibirSalas();

                        System.out.println("\nDigite o número da sala que deseja informações: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        cinema.relatorioDaSala(num);
                        break;

                    case 5:
                        System.out.println("\nCadastro de pessoa para compra de ingresso");

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Categoria (normal/estudante/idoso/professor): ");
                        String categoria;
                        while (true) {
                            categoria = scanner.nextLine().toLowerCase();
                            if (categoria.equals("normal") ||
                                    categoria.equals("estudante") ||
                                    categoria.equals("idoso") ||
                                    categoria.equals("professor")) {
                                break;
                            } else {
                                System.out.println("Categoria inválida. Tente novamente:");
                            }
                        }

                        Pessoa pessoa = new Pessoa(nome, idade, categoria);

                        System.out.print("Número da sala: ");
                        int numS = scanner.nextInt();
                        scanner.nextLine();

                        Sala sala = cinema.getSalaPorNum(numS);
                        if (sala == null) {
                            System.out.println("Sala não encontrada.");
                            break;
                        }

                        System.out.print("Fileira (A-T): ");
                        String fileiraStr = scanner.nextLine().toUpperCase();
                        if (fileiraStr.length() != 1 || fileiraStr.charAt(0) < 'A' || fileiraStr.charAt(0) > 'T') {
                            System.out.println("Fileira inválida.");
                            break;
                        }
                        char fileira = fileiraStr.charAt(0);

                        System.out.print("Número do assento (1-10): ");
                        int numAssento = scanner.nextInt();
                        if (numAssento < 1 || numAssento > 10) {
                            System.out.println("Número do assento inválido.");
                            break;
                        }

                        Assento assen = sala.getAssento(fileira, numAssento);

                        if (assen == null) {
                            System.out.println("Assento inválido.");
                        } else if (assen.isOcupado()) {
                            System.out.println("Assento já está ocupado!");
                        } else {
                            assen.ocupar();
                            double precoBase = 15;
                            double precoFinal = pessoa.calcularDesconto(precoBase);
                            Ingresso ingresso = new Ingresso(pessoa, sala, assen, precoFinal);
                            cinema.registrarCompra(ingresso);
                            System.out.printf("Ingresso comprado! Valor final: R$ %.2f\n", precoFinal);
                        }
                        break;

                    case 6:
                        List<Ingresso> historico = cinema.getHistorico();
                        if (historico.isEmpty()) {
                            System.out.println("Nenhuma compra registrada.");
                        } else {
                            System.out.println("\nHistórico de compras:");
                            for (Ingresso ing : historico) {
                                String data = ing.getDataHora().format(fmt);
                                String nomePessoa = ing.getPessoa() != null ? ing.getPessoa().getNome() : "-";
                                String cat = ing.getPessoa() != null ? ing.getPessoa().getCategoria() : "-";
                                int salaNum = ing.getSala() != null ? ing.getSala().getNumSala() : -1;
                                char fil = ing.getAssento() != null ? ing.getAssento().getFileira() : '?';
                                int cad = ing.getAssento() != null ? ing.getAssento().getCadeira() : -1;
                                double valor = ing.getPrecoFinal();
                                System.out.printf("%s | Sala %d | Assento %c%d | %s (%s) | R$ %.2f%n",
                                        data, salaNum, fil, cad, nomePessoa, cat, valor);
                            }
                            System.out.printf("Total de ingressos: %d | Faturamento: R$ %.2f%n",
                                    cinema.getTotalIngressosVendidos(), cinema.getTotalFaturado());
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, revise os dados e tente novamente.");
                scanner.nextLine();
                opc = -1;
            }
        } while (opc != 0);

        scanner.close();
    }
}
