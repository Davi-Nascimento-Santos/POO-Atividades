public class Conta {
    private int num;
    private double saldo;
    private Pessoa dono;
    private Extrato extrato = new Extrato();
    public Conta(int n, Pessoa p){
        this.num = n;
        this.saldo = 0;
        this.extrato.setConta(this);
        if (p != null){
            if (p.getConta() != null){
                System.out.println("ERRO! Usuário já tem conta!");
                return;
            }else{
                this.dono = p;
                p.setConta(this);
            }
        }else{
            System.out.println("ERRO! Usuário inválido!");
        }
    }

    public int getNum() {
        return num;
    }

    public double getSaldo() {
        return saldo;
    }

    public void Credito(double v){
        this.saldo += v;
        this.extrato.addCredito(v, this.saldo);
    }

    public void Debito(double v){
        if (this.saldo >= v){
            this.saldo -= v;
            this.extrato.addDebito(v, this.saldo);
        }else{
            System.out.println("ERRO! Valor ultrapassa o saldo!");
        }
    }

    public String getDono() {
        return dono.getNome();
    }
    public void getExtrato(int n){
        this.extrato.show(n);
    }
}