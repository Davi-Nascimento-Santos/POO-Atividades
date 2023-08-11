import java.util.ArrayList;
import java.util.Date;

public class MinhaAssociacao implements InterfaceAssociacao {
    protected ArrayList<Associacao> associacoes = new ArrayList<Associacao>();

    //Método para 
    public double calcularFrequencia(int numAssociado, int numAssociacao, long inicio, long fim) throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente {
        Date dataInicio = new Date(inicio);
        Date dataFim = new Date(fim);
        Associacao ass = pesquisa(numAssociacao);
        if (ass != null){
            Associado a = ass.pesquisarAssociado(numAssociado);
            if (a != null){
                double frequencia = 0;
                double totalReunioes = 0;
                for (Reuniao r: ass.getReunioes()){
                    if (r.getData().compareTo(dataInicio) >=0 && r.getData().compareTo(dataFim)<=0){
                        if (r.pesquisarParticipante(numAssociado)!=null){
                            frequencia++;
                        }
                        totalReunioes++;   
                    }
                }
                if (totalReunioes==0){
                    throw new ReuniaoNaoExistente();
                }else{
                    return frequencia / totalReunioes;
                }
            }else{
                throw new AssociadoNaoExistente();
            }
        }else{
            throw new AssociacaoNaoExistente();
        }
    }

    //Método para registrar a frequencia de um associado em uma reuniao
    public void registrarFrequencia(int codigoAssociado, int numAssociacao, long dataReuniao) throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente, FrequenciaJaRegistrada, FrequenciaIncompativel {
        Date dt = new Date(dataReuniao);
        Associacao ass = pesquisa(numAssociacao);
        if (ass!=null){
            if (ass.pesquisarAssociado(codigoAssociado)!=null){
                Associado a = ass.pesquisarAssociado(codigoAssociado);
                if (a.getDataAssociacao().after(dt)){
                    throw new FrequenciaIncompativel();
                }
                Reuniao r = ass.pesquisarReuniao(dt);
                r.adicionarParticante(a);
            }else{
                throw new AssociadoNaoExistente();
            }
        }else{
            throw new AssociacaoNaoExistente();
        }
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

    //Método para adicionar um associado
    public void adicionar(int associacao, Associado a) throws AssociacaoNaoExistente, AssociadoJaExistente, ValorInvalido {
        if (associacao <= 0){
            throw new ValorInvalido();
        }
        Associacao ass = pesquisa(associacao);
        if (ass != null){
            ass.adicionarAssociado(a);
        }else{
            throw new AssociacaoNaoExistente();
        }
    }

    //Método para adicionar uma reunião
    public void adicionar(int associacao, Reuniao r) throws AssociacaoNaoExistente, ReuniaoJaExistente, ValorInvalido {
        if (associacao <= 0){
            throw new ValorInvalido();
        }
        Associacao ass = pesquisa(associacao);
        if (ass != null){
            ass.adicionarReuniao(r);
        }else{
            throw new AssociacaoNaoExistente();
        }    
    }

    //Método para adicionar uma taxa
    public void adicionar(int associacao, Taxa t) throws AssociacaoNaoExistente, TaxaJaExistente, ValorInvalido {
        if (associacao <=0){
            throw new ValorInvalido();
        }
        Associacao ass = pesquisa(associacao);
        if (ass != null){
            ass.adicionarTaxa(t);
        }else{
            throw new AssociacaoNaoExistente();
        }
    }
    
}
