import java.util.ArrayList;

public class Associacao {
    protected int numero;
    protected String nome;
    protected ArrayList<Associado> associados = new ArrayList<Associado>();
    protected ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();
    protected ArrayList<Taxa> taxas = new ArrayList<Taxa>();

    public Associacao(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    //Método para pesquisar um associado
    public Associado pesquisarAssociado(int num){
        for (Associado a: associados){
            if (a.getNumero() == num){
                return a;
            }
        }
        return null;
    }

    //Método para pesquisar uma reunião
    public Reuniao pesquisarReuniao(Reuniao re){
        for (Reuniao r: reunioes){
            if (r.equals(re)){
                return r;
            }
        }
        return null;
    }

    //Método para pesquisar uma taxa
    public Taxa pesquisarTaxa(Taxa tx){
        for (Taxa t: taxas){
            if (t.getNome()==tx.getNome() && t.getVigencia()==tx.getVigencia()){
                return t;
            }
        }
        return null;
    }
    
    //Método para adicionar um associado
    public void adicionarAssociado(Associado a) throws ValorInvalido, AssociadoJaExistente{
        if (a.getNome().isEmpty()==true || a.getNome().isBlank()==true || a.getTelefone().isEmpty()==true || a.getTelefone().isBlank()==true || a.getNumero()<=0 || a.getNascimento()==null || a.getDataAssociacao()==null){
            throw new ValorInvalido();
        }
        if (pesquisarAssociado(a.getNumero())==null){
            if (a instanceof AssociadoRemido){
                if (((AssociadoRemido)a).dataRemissao!=null){
                    associados.add(a);
                }else{
                    throw new ValorInvalido();
                }
            }
            associados.add(a);
        }else{
            throw new AssociadoJaExistente();
        }
    }

    //Método para adicionar uma reunião
    public void adicionarReuniao(Reuniao r) throws ValorInvalido, ReuniaoJaExistente{
        if (r.getAta().isEmpty()==true || r.getAta().isBlank()==true || r.getData()==null){
            throw new ValorInvalido();
        }
        if (pesquisarReuniao(r)==null){
            reunioes.add(r);
        }else{
            throw new ReuniaoJaExistente();
        }
    }

    //Metódo para adicionar uma taxa
    public void adicionarTaxa(Taxa t) throws ValorInvalido, TaxaJaExistente{
        if (t.getNome().isBlank()==true || t.getNome().isEmpty()==true || t.getParcelas()<=0 || t.getTaxaMensal()<=0 || t.getValorAno()<=0 || t.getVigencia()<=0){
            throw new ValorInvalido();
        }
        if (pesquisarTaxa(t)==null){
            taxas.add(t);
        }else{
            throw new TaxaJaExistente();
        }
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
}
