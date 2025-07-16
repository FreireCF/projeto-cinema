package Models;

public class Ingresso {
    protected Pessoa pessoa;
    protected Sala sala;
    protected Assento[][] assentos;
    protected double precoFinal;

    public Ingresso(Pessoa pessoa, Sala sala, Assento[][] assentos){
        this.pessoa = pessoa;
        this.sala = sala;
        this.assentos = assentos;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public Sala getSala() {
        return sala;
    }

    public Assento[][] getAssentos() {
        return assentos;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setAssentos(Assento[][] assentos) {
        this.assentos = assentos;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
}