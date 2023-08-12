import java.util.Date;

public class AssociadoRemido extends Associado {
    protected Date dataRemissao;

    public AssociadoRemido(int numero, String nome, String telefone, long dataAssociacao, long nascimento, long dataRemissao) {
        super(numero, nome, telefone, dataAssociacao, nascimento);
        Date dtr = new Date(dataRemissao);
        this.dataRemissao = dtr;
    }

    public Date getDataRemissao() {
        return dataRemissao;
    }
}
