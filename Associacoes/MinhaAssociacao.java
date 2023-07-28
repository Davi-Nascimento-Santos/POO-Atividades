import java.util.Date;

public class MinhaAssociacao implements InterfaceMinhaAssociacao {

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

    @Override
    public void adicionar(Associacao a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }

    @Override
    public void adicionar(int associacao, Associado a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }

    @Override
    public void adicionar(int associacao, Reuniao r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }

    @Override
    public void adicionar(int associacao, Taxa t) throws TaxaJaExistente {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }


}