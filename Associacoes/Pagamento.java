import java.util.Date;

public class Pagamento {
    protected Taxa taxa;
    protected double valor;
    protected Date data;
    
    public Pagamento(Taxa taxa, double valor, Date data) {
        this.taxa = taxa;
        this.valor = valor;
        this.data = data;
    }

    public Taxa getTaxa() {
        return taxa;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
    
    
    
}
