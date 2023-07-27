import java.util.Date;

public class AssociadoRemido extends Associado{
    protected Date dataRemissao;

    public AssociadoRemido(int numero, String nome, String telefone, Date dataAssociacao, Date nascimento, Date dataRemissao) {
        super(numero, nome, telefone, dataAssociacao, nascimento);
        this.dataRemissao=dataRemissao;
    }
    
}
