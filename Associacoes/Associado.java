import java.util.ArrayList;
import java.util.Date;

public class Associado {
    protected int numero;
    protected String nome;
    protected String telefone;
    protected Date dataAssociacao;
    protected Date nascimento;
    protected ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

    public Associado(int numero, String nome, String telefone, long dataAssociacao, long nascimento) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        Date dt = new Date(dataAssociacao);
        this.dataAssociacao = dt;
        Date nasc = new Date(nascimento);
        this.nascimento = nasc;
    }


    public int getNumero() {
        return numero;
    }


    public String getNome() {
        return nome;
    }


    public String getTelefone() {
        return telefone;
    }


    public Date getDataAssociacao() {
        return dataAssociacao;
    }


    public Date getNascimento() {
        return nascimento;
    }

    public void registrarPagamento(Taxa taxa, double valor, Date data){
        Pagamento p = new Pagamento(taxa, valor, data);
        pagamentos.add(p);
    }


    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public Taxa pesquisaTaxa(String nome, int vigencia){
        for (Pagamento p: pagamentos){
            if (p.getTaxa().getVigencia()==vigencia && p.getTaxa().getNome()==nome){
                return p.getTaxa();
            }
        }
        return null;
    }
    
}
