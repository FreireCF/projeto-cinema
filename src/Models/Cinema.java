package Models;

public class Cinema {
    protected Sala[] salas;

    public Cinema(){}

    public Sala[] getSalas(){
        return salas;
    }

    public void cadastrarFilme(Filme filme){

    }

    public void exibirFilmes(){
        System.out.println("\nNome: "+salas);
        System.out.println("\nDuração: "+duracao+" minutos");
        System.out.println("\nGênero: "+genero);
    }
}
