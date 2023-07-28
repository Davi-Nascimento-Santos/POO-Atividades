import java.util.ArrayList;

public class Associacao {
    protected int num;
    protected String nome;
    protected ArrayList<Associado> associados = new ArrayList<Associado>();
    protected ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();

    public Associacao(int num, String nome){
        this.num=num;
        this.nome=nome;
    }
}
