package Models;

public class Filme {
    protected String titulo;
    protected double duracao;
    protected String genero;

    public Filme(String titulo, double duracao, String genero){
        this.titulo= titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public double getDuracao(){
        return this.duracao;
    }

    public String getGenero(){
        return this.genero = genero;
    }

    public void setNome(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void exibirFilmes(){
        System.out.println("\nNome: "+this.titulo);
        System.out.println("\nDuração: "+this.duracao);
        System.out.println("\nGênero: "+this.genero);
    }

    public String toString(){
        return "\nNome: "
                +this.titulo
                +"\nDuração: "
                +duracao+
                "minutos"
                +"\nGênero: "
                +genero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Filme filme = (Filme) obj;
        return titulo.equalsIgnoreCase(filme.titulo); // ou comparar por ID se tiver
    }

}
