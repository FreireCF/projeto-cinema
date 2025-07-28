package Models;

public class Assento {
    protected char fileira; //A-T
    protected int numero;// 1-10
    protected boolean status; //livre ou ocupado

    public Assento(char fileira, int numero){
        this.fileira = fileira;
        this.numero = numero;
        this.status = false;
    }

    public char getFileira() {
        return fileira;
    }

    public int getCadeira() {
        return numero;
    }

    public boolean isOcupado() {
        return status;
    }

    public void ocupar(){
        this.status = true;
    }

    public void liberar(){
        this.status = false;
    }
}