public class Taxa {
    protected String nome;
    protected int vigencia;
    protected double valorAno;
    protected int parcelas;
    protected boolean administrativa;
    protected double taxaMensal;
    
    public Taxa(String nome, int vigencia, double valorAno, int parcelas, boolean administrativa) {
        this.nome = nome;
        this.vigencia = vigencia;
        this.valorAno = valorAno;
        this.parcelas = parcelas;
        this.administrativa = administrativa;
        this.taxaMensal = valorAno/12;
    }

    public String getNome() {
        return nome;
    }

    public int getVigencia() {
        return vigencia;
    }

    public double getValorAno() {
        return valorAno;
    }

    public int getParcelas() {
        return parcelas;
    }

    public boolean isAdministrativa() {
        return administrativa;
    }

    public double getTaxaMensal() {
        return taxaMensal;
    }
    

    
}
