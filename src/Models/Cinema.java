package Models;
import java.util.List;
import java.util.ArrayList;

public class Cinema {
    protected List<Sala> salas = new ArrayList<>();
    protected List<Filme> filmes = new ArrayList<>();
    private List<Ingresso> historico = new ArrayList<>();

    public Cinema() {}

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

    public List<Filme> exibirFilmesNaoAlocados(){
        List<Filme> naoAlocados = new ArrayList<>(filmes);
        for(Sala s : salas){
            if(s.getFilme() != null){
                naoAlocados.remove(s.getFilme());
            }
        }
        return naoAlocados;
    }

    public void alocarFilmeEmSala(int numeroSala, String nomeFilme){
        Sala sala = getSalaPorNum(numeroSala);
        for(Filme f : filmes){
            if(f.getTitulo().equalsIgnoreCase(nomeFilme)){
                if (sala != null) {
                    sala.setFilme(f);
                }
                break;
            }
        }
    }

    public void relatorioDaSala(int numeroSala){
        Sala sala = getSalaPorNum(numeroSala);
        if(sala != null){
            System.out.println("Sala " + sala.getNumSala());
            System.out.println("Filme: " + (sala.getFilme() != null ? sala.getFilme().getTitulo() : "Nenhum"));
            sala.mostrarAssentos();
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    public void registrarCompra(Ingresso ingresso){
        historico.add(ingresso);
    }

    public List<Ingresso> getHistorico(){
        return historico;
    }

    public List<Ingresso> getHistoricoPorSala(int numSala){
        List<Ingresso> list = new ArrayList<>();
        for (Ingresso i : historico) {
            if (i.getSala() != null && i.getSala().getNumSala() == numSala) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Ingresso> getHistoricoPorPessoa(String nome){
        List<Ingresso> list = new ArrayList<>();
        for (Ingresso i : historico) {
            if (i.getPessoa() != null && i.getPessoa().getNome().equalsIgnoreCase(nome)) {
                list.add(i);
            }
        }
        return list;
    }

    public double getTotalFaturado(){
        double total = 0.0;
        for (Ingresso i : historico) {
            total += i.getPrecoFinal();
        }
        return total;
    }

    public int getTotalIngressosVendidos(){
        return historico.size();
    }
}
