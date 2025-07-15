package Models;

public class Pessoa {
    protected String nome;
    protected int idade;
    protected String categoria;

    public Pessoa(String nome, int idade, String categoria){
        this.nome = nome;
        this.idade = idade;
        if(!validarCategoria(categoria)){
            return;
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
        if(!validarCategoria(categoria)){
            return;
        }
        this.categoria = categoria;
    }

    public boolean validarCategoria(String categoria){
        if(categoria.toUpperCase().equals("NORMAL") || categoria.toUpperCase().equals("ESTUDANTE") || categoria.toUpperCase().equals("IDOSO") || categoria.toUpperCase().equals("PROFESSOR")){
            System.out.println("\nCategoria inválida");
            return false;
        }
        return true;
    }
}
