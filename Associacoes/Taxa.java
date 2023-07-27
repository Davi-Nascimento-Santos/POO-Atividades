public class Taxa {
    protected String nome;
    protected int vigencia;
    protected double valorAno;
    protected int parcelas;
    protected boolean adminstrativa;

    public Taxa(String nome, int vigencia, double valorAno, int parcelas, boolean administrativa){
        this.nome=nome;
        this.vigencia=vigencia;
        this.valorAno=valorAno;
        this.parcelas=parcelas;
        this.adminstrativa=administrativa;
    }
}
