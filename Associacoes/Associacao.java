import java.util.ArrayList;

public class Associacao {
    protected int num;
    protected String nome;
    protected ArrayList<Associado> associados = new ArrayList<Associado>();
    protected ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();
    protected ArrayList<Taxa> taxas = new ArrayList<Taxa>();

    public Associacao(int num, String nome){
        this.num=num;
        this.nome=nome;
    }

    //Método para adicionar associados
    public boolean adicionarAssociados(Associado a) throws AssociadoJaExistente{
        for (Associado ass: associados){
            if (ass.getNumero() == a.getNumero()){
                throw new AssociadoJaExistente();
            }
        }
        associados.add(a);
        return true;
    }
    public boolean adicionarTaxa(Taxa t){
        for (Taxa ta: taxas){
            if (t.getNome() == ta.getNome() && ta.getVigencia() == t.getVigencia()  && ta.valorAno == t.getValorAno() && ta.getParcelas() == t.getParcelas()){
                return false;
            }
        }
        taxas.add(t);
        return true;
    }

    public int getNum() {
        return num;
    }

    public String getNome() {
        return nome;
    }
    
}
