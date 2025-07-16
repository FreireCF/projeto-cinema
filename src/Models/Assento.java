package Models;

public class Assento {
    protected String[] fileira; //A-T
    protected String[] cadeira; //1-10
    protected String status; //livre ou ocupado
    protected int contFileira=0;
    protected int contCadeira=0;

    public Assento(String fileira, String cadeira, String status){
        this.fileira[contFileira] = fileira;
        this.cadeira[contCadeira] = cadeira;
        this.status = status;
        contFileira++;
        contCadeira++;
    }

    public String[] getFileira() {
        return fileira;
    }

    public String[] getCadeira() {
        return cadeira;
    }

    public String getStatus() {
        return status;
    }

    public int getContFileira() {
        return contFileira;
    }

    public int getContCadeira() {
        return contCadeira;
    }

    public void setFileira(String[] fileira) {
        this.fileira = fileira;
    }

    public void setCadeira(String[] cadeira) {
        this.cadeira = cadeira;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setContFileira(int contFileira) {
        this.contFileira = contFileira;
    }

    public void setContCadeira(int contCadeira) {
        this.contCadeira = contCadeira;
    }
}