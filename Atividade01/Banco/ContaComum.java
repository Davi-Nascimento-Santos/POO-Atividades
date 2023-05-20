package Banco;

public class ContaComum {
	
	private int num;
	private double saldo;
	private String extrato = "";
	private Pessoa dono;

	
	public ContaComum(int n, Pessoa p) {
	   num = n;	
	   if (p.getConta() == null) {
	     dono = p;
	     p.setConta(this);
	   } else {
		 System.out.println("Essa pessoa já possui uma conta");
		 return;
	   }
	}
	
	public void credito(double val) {
		saldo = saldo + val;
		extrato = extrato + "Credito: " + val + 
				" Saldo: " + saldo + "\n";
	}
	
	public void debito(double val) {
		saldo = saldo - val;
		extrato = extrato + "Debito: " + val + 
				" Saldo: " + saldo + "\n";
	}

	public int getNum() {
		return num;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getExtrato() {
		return extrato;
	}
	
	public Pessoa getDono() {
		return dono;
	}
	
}
