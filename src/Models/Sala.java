package Models;
import java.util.ArrayList;
import java.util.List;

public class Sala {
    protected int numSala;
    private Assento[][] assentos = new Assento[20][10];
    protected Filme filme;

    public Sala(int numSala) {
        this.numSala = numSala;
        this.filme = null;
        char letra = 'A';
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                assentos[i][j] = new Assento(letra, j + 1);
            }
            letra++;
        }
    }

    public int getNumSala(){
        return numSala;
    }

    public Assento[][] getAssentos(){
        return assentos;
    }

    public Filme getFilme(){
        return filme;
    }

    public void setNumSala(int numSala){
        this.numSala = numSala;
    }

    public void setFilme(Filme filme){
        this.filme = filme;
    }

//    public Assento getAssento(char fileira, int numero) { //assento específico, provavelmtene n usarei
//        int linha = fileira - 'A';
//        int coluna = numero - 1;
//
//        if (linha >= 0 && linha < 20 && coluna >= 0 && coluna < 10) {
//            return assentos[linha][coluna];
//        } else {
//            return null;
//        }
//    }


}