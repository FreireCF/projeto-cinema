package Models;

import java.util.ArrayList;

public class Sala {
    protected String numSala;
    protected Assento[][] assentos;
    protected Filme[] filmes;
    protected int contFilmes=0;

    public Sala(String numSala, Assento[][] assento){
        this.numSala = numSala;
        this.assentos = assentos;
        this.filmes = new Filme[10];
    }

    public String getNumSala(){
        return numSala;
    }

    public Assento[][] getAssento(){
        return assentos;
    }

    public Filme[] getFilme(){
        return filmes;
    }

    public void setNumSala(String numSala){
        this.numSala = numSala;
    }

    public void setAssentos(Assento[][] assentos){
        this.assentos = assentos;
    }

    public void setFilme(Filme filme){
        this.filmes.add(filme);
    }

//    public alocarFilme(Filme filme){
//         this.filmes.add(filme);
//    }

    public ArrayList<Filme> filmesAlocados(){

    }

}
