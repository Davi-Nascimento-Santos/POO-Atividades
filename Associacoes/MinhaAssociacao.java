import java.util.ArrayList;
import java.util.Date;

public class MinhaAssociacao implements InterfaceMinhaAssociacao {
    protected ArrayList<Associacao> associacoes = new ArrayList<Associacao>();

    @Override
    public double calcularFrequencia(int numAssociado, int numAssociacao, Date inicio, Date fim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularFrequencia'");
    }

    @Override
    public void registrarFrequencia(int codigoAssociado, int numAssociacao, Date dataReuniao)
            throws FrequenciaJaRegistrada, FrequenciaIncompativel {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarFrequencia'");
    }

    @Override
    public void registrarPagamento(int numAssociacao, String taxa, int vigencia, int numAssociado, Date data,
            double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarPagamento'");
    }

    @Override
    public double somarPagamentoDeAssociado(int numAssociacao, int numAssociado, String nomeTaxa, int vigencia,
            Date inicio, Date fim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'somarPagamentoDeAssociado'");
    }

    @Override
    public double calcularTotalDeTaxas(int numAssociacao, int vigencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotalDeTaxas'");
    }

    //Método para pesquisar uma associação
    private Associacao pesquisarAssociacao(int cod){
        for (Associacao a: associacoes){
            if (a.getNum() == cod){
                return a;
            }
        }
        return null;
    }

    //Método para verificar se uma associação é válida
    private boolean verificaAssociacao(Associacao a){
        if (a.getNum() > 0 && a.getNome().isEmpty() == false && a.getNome().isBlank() == false){
            return true;
        }
        return false;
    }

    //Método para verificar se um associado é válido
    private boolean verificaAssociado(Associado a){
        if (a.getNumero() > 0 && a.getNome().isBlank() == false && a.getNome().isEmpty()==false && a.getTelefone().isBlank()==false && a.getTelefone().isEmpty()==false && a.getNascimento()!=null && a.getDataAssociacao()!=null){
            return true;
        }
        return false;
    }

    //Método para verificar se uma taxa é válida
    private boolean verificarTaxa(Taxa t){
        if (t.getNome().isBlank() == false && t.getNome().isEmpty()==false && t.getParcelas()>0 && t.getValorAno()>0 && t.getVigencia()>0){
            return true;
        }
        return false;
    }

    //Método para adicionar uma associação
    public void adicionar(Associacao a) throws ValorInvalido, AssociacaoJaExistente{
        if (verificaAssociacao(a)){
            Associacao ass = pesquisarAssociacao(a.getNum());
            if (ass == null){
                associacoes.add(a);
            }else{
                throw new AssociacaoJaExistente();
            }
        }else{
            throw new ValorInvalido();
        }
    }

    //Método para adiconar um associado a uma associação
    public void adicionar(int associacao, Associado a) throws ValorInvalido, AssociacaoNaoExistente, AssociadoJaExistente{
        if (associacao > 0){
            if (verificaAssociado(a)){
                Associacao ass = pesquisarAssociacao(associacao);
                if (ass != null){
                    ass.adicionarAssociados(a);
                }else{
                    throw new AssociacaoNaoExistente();
                }
            }else{
                throw new ValorInvalido();
            }
        }else{
            throw new ValorInvalido();
        }
    }

    @Override
    public void adicionar(int associacao, Reuniao r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }

    //Método para adicionar uma taxa a uma associação
    public void adicionar(int associacao, Taxa t) throws TaxaJaExistente, AssociacaoNaoExistente, ValorInvalido {
        if (associacao > 0){
            if (verificarTaxa(t)){
                Associacao ass = pesquisarAssociacao(associacao);
                if (ass != null){
                    ass.adicionarTaxa(t);
                }else{
                    throw new AssociacaoNaoExistente();
                }
            }else{
                throw new ValorInvalido();
            }
        }
        throw new ValorInvalido();
    }


}