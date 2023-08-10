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
    

}
