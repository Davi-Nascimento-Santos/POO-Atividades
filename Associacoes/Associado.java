import java.util.Date;

public class Associado {
    protected int numero;
    protected String nome;
    protected String telefone;
    protected Date dataAssociacao;
    protected Date nascimento;


    public Associado(int numero, String nome, String telefone, Date dataAssociacao, Date nascimento) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.dataAssociacao = dataAssociacao;
        this.nascimento = nascimento;
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
    
}
