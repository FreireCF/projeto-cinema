package Models;

import java.time.LocalDateTime;

public class Ingresso {
    protected Pessoa pessoa;
    protected Sala sala;
    protected Assento assento;
    protected double precoFinal;
    protected LocalDateTime dataHora;

    public Ingresso(Pessoa pessoa, Sala sala, Assento assento, double precoFinal) {
        this.pessoa = pessoa;
        this.sala = sala;
        this.assento = assento;
        this.precoFinal = precoFinal;
        this.dataHora = LocalDateTime.now();
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

    public LocalDateTime getDataHora() {
        return dataHora;
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

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
