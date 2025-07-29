package Models;

public class Pessoa {
    protected String nome;
    protected int idade;
    protected String categoria;

    public Pessoa() {}

    public Pessoa(String nome, int idade, String categoria){
        this.nome = nome;
        this.idade = idade;

        if (!validarCategoria(categoria)) {
            throw new IllegalArgumentException("Categoria inválida: " + categoria);
        }

        this.categoria = categoria;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setCategoria(String categoria){
        if (!validarCategoria(categoria)) {
            throw new IllegalArgumentException("Categoria inválida: " + categoria);
        }
        this.categoria = categoria;
    }

    public double calcularDesconto(double precoBase) {
        switch (categoria.toLowerCase()) {
            case "estudante":
                return precoBase * 0.5;
            case "idoso":
                if (idade >= 60) {
                    return 0.0;
                } else {
                    return precoBase;
                }
            case "professor":
                return precoBase * 0.7;
            default:
                return precoBase;
        }
    }


    private boolean validarCategoria(String categoria) {
        return categoria != null &&
                (categoria.equalsIgnoreCase("normal") ||
                        categoria.equalsIgnoreCase("estudante") ||
                        categoria.equalsIgnoreCase("idoso") ||
                        categoria.equalsIgnoreCase("professor"));
    }
}
