import java.util.ArrayList;
import java.util.Date;

public class MinhaAssociacao implements InterfaceAssociacao {
    protected ArrayList<Associacao> associacoes = new ArrayList<Associacao>();

    @Override
    public double calcularFrequencia(int numAssociado, int numAssociacao, Date inicio, Date fim)
            throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularFrequencia'");
    }

    @Override
    public void registrarFrequencia(int codigoAssociado, int numAssociacao, Date dataReuniao)
            throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente, FrequenciaJaRegistrada,
            FrequenciaIncompativel {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarFrequencia'");
    }

    @Override
    public void registrarPagamento(int numAssociacao, String taxa, int vigencia, int numAssociado, Date data,
            double valor)
            throws AssociacaoNaoExistente, AssociadoNaoExistente, AssociadoJaRemido, TaxaNaoExistente, ValorInvalido {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarPagamento'");
    }

    @Override
    public double somarPagamentoDeAssociado(int numAssociacao, int numAssociado, String nomeTaxa, int vigencia,
            Date inicio, Date fim) throws AssociacaoNaoExistente, AssociadoNaoExistente, TaxaNaoExistente {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'somarPagamentoDeAssociado'");
    }

    @Override
    public double calcularTotalDeTaxas(int numAssociacao, int vigencia)
            throws AssociacaoNaoExistente, TaxaNaoExistente {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotalDeTaxas'");
    }

    //Método para pesquisar uma associação
    private Associacao pesquisa(int num){
        for (Associacao a: associacoes){
            if (a.getNumero() == num){
                return a;
            }
        }
        return null;
    }

    //Método para adicionar uma associação
    public void adicionar(Associacao a) throws AssociacaoJaExistente, ValorInvalido {
        Associacao ass = pesquisa(a.getNumero());
        if (ass == null){
            if (a.getNome()!=null && a.getNome().isBlank()!=true && a.getNome().isEmpty()!=true && a.getNumero() > 0){
                associacoes.add(a);
            }else{
                throw new ValorInvalido();
            }
        }else{
            throw new AssociacaoJaExistente();
        }
    }

    @Override
    public void adicionar(int associacao, Associado a)
            throws AssociacaoNaoExistente, AssociadoJaExistente, ValorInvalido {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }

    @Override
    public void adicionar(int associacao, Reuniao r) throws AssociacaoNaoExistente, ReuniaoJaExistente, ValorInvalido {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }

    @Override
    public void adicionar(int associacao, Taxa t) throws AssociacaoNaoExistente, TaxaJaExistente, ValorInvalido {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }
    
}
