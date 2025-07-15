package Models;

public class Assento {
    protected String fileira; // A-T
    protected byte numero; //1-10
    protected String status; //livre ou ocupado

    public Assento(String fileira, byte numero, String status){
        this.fileira = fileira;
        this.numero = numero;
        this.status = status;
    }


}
