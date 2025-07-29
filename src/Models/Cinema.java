package Models;
import java.util.List;
import java.util.ArrayList;

public class Cinema {
    protected List<Sala> salas = new ArrayList<>();
    protected List<Filme> filmes = new ArrayList<>();

    public Cinema() {
    }

    public List<Sala> getSalas(){
        return this.salas;
    }

    public Sala getSalaPorNum(int num){
        for(Sala s : salas){
            if(s.getNumSala() == num){
                return s;
            }
        }
        return null;
    }

    public void cadastrarSala(Sala s){
        salas.add(s);
    }

    public void exibirSalasSemFilme(){
        for(Sala s : salas){
            if(s.getFilme() == null){
                System.out.println("\nSala "+s.getNumSala());
            }
        }
    }

    public void exibirSalas(){
        for(Sala s : salas){
            System.out.println("\nSala "+s.getNumSala());
        }
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void relatorioDaSala(int numSala) {
        for (Sala s : salas) {
            if(s.getNumSala() == numSala){
                System.out.println("===================================");
                System.out.println("Sala: " + s.getNumSala());

                Filme filme = s.getFilme();
                if (filme != null) {
                    System.out.println("Filme: " + filme.getTitulo());
                } else {
                    System.out.println("Sem filme alocado");
                }

                Assento[][] assentos = s.getAssentos();
                int ocupados = 0;
                int livres = 0;

                System.out.println("\nMapa de assentos:");
                System.out.print("   ");
                for (int i = 1; i <= 10; i++) {
                    System.out.printf("%2d ", i);
                }
                System.out.println();

                for (int i = 0; i < assentos.length; i++) {
                    System.out.printf("%2c ", (char) ('A' + i)); //  fileira
                    for (int j = 0; j < assentos[i].length; j++) {
                        if (assentos[i][j].isOcupado()) {
                            System.out.print(" X ");
                            ocupados++;
                        } else {
                            System.out.print(" O ");
                            livres++;
                        }
                    }
                    System.out.println();
                }

                System.out.println("\nAssentos ocupados: " + ocupados);
                System.out.println("\nAssentos livres:   " + livres);
                System.out.println("===================================\n");
            }
        }
    }


//    public void exibirFilmesAlocados() {
//        for (Sala s : salas) {
//                if (s != null) {
//                    s.getFilme();
//            }
//        }
//    }

    public List<Filme> exibirFilmesNaoAlocados() {
            List<Filme> naoAlocados = new ArrayList<>();

            for (Filme f : filmes) {
                boolean alocado = false;
                for (Sala s : salas) {
                    if (s.getFilme() != null && s.getFilme().equals(f)) {
                        alocado = true;
                        break;
                    }
                }
                if (!alocado) {
                    naoAlocados.add(f);
                }
            }

            return naoAlocados;
    }

    public void alocarFilmeEmSala(int numSala, String tituloF) {
        Filme filmeEncontrado = null;
        boolean alocou = false;
        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(tituloF)) {
                filmeEncontrado = f;
            }
        }

        if (filmeEncontrado == null) {
            System.out.println("\nFilme " + tituloF + " não encontrado");
            return;
        }

        for (Sala s : salas) {
            if (s.getNumSala() == numSala) {
                s.setFilme(filmeEncontrado);
                System.out.println("\nFilme " + filmeEncontrado.getTitulo() + " alocado na sala " + numSala);
                alocou = true;
            }
        }
        if (!alocou) {
            System.out.println("Sala " + numSala + " não encontrada");
        }
    }
}