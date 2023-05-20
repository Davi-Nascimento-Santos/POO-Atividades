public class Extrato {
    private Conta conta;
    private double [][] credito = new double [10][2];
    private int cred = 0;
    private int debi = 0;
    private double [][] debito = new double[10][2];
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public double[][] getCredito() {
        return credito;
    }
    public void addCredito(double credito, double valor) {
        this.credito[cred][0] = credito;
        this.credito[cred][1] = valor;
        if (this.cred == 10){
            this.cred = 0;
        }
        this.cred++;
    }
    public double[][] getDebito() {
        return debito;
    }
    public void addDebito(double debito, double valor) {
        this.debito[debi][0] = debito;
        this.debito[debi][1] = valor;
        if (this.debi == 10){
            this.debi = 0;
        }
        this.debi++;
    }
    public void show(int n){
        if (n==0){
            for (int i=0; i< this.cred; i++){
                System.out.println("Crédito: " + this.credito[i][0] + " Saldo: " + this.credito[i][1]);
            }
        }else{
            for (int i=0; i< this.debi; i++){
                System.out.println("Débito: " + this.debito[i][0] + " Saldo: " + this.debito[i][1]);
            }
        }
    }
    

    

    
}
