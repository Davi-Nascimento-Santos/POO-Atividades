import java.util.ArrayList;

public class Associacao {
    protected int numero;
    protected String nome;
    protected ArrayList<Associado> associados = new ArrayList<Associado>();
    protected ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();
    
    public Associacao(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Associado> getAssociados() {
        return associados;
    }

    public ArrayList<Reuniao> getReunioes() {
        return reunioes;
    }

    
    

}
