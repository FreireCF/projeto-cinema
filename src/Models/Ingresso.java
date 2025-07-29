package Models;

public class Ingresso {
    protected Pessoa pessoa;
    protected Sala sala;
    protected Assento assento;
    protected double precoFinal;

    public Ingresso(Pessoa pessoa, Sala sala, Assento assento, double precoFinal) {
        this.pessoa = pessoa;
        this.sala = sala;
        this.assento = assento;
        this.precoFinal = precoFinal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Sala getSala() {
        return sala;
    }

    public Assento getAssento() {
        return assento;
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

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
}
