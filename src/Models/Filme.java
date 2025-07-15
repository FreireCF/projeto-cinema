package Models;

public class Filme {
    protected String nome;
    protected double duracao;
    protected String genero;

    public Filme(String nome, double duracao, String genero){
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getNome(){
        return this.nome;
    }

    public double getDuracao(){
        return this.duracao;
    }

    public String getGenero(){
        return this.genero = genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
