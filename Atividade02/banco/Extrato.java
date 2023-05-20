package banco;
import java.util.Date;

public class Extrato {

	private String operacao;
	private double valor;
	private double saldo;
	private Date date;
	
	public Extrato(String op, double v, double s, Date d) {
		operacao = op;
		valor = v;
		saldo = s;
		date = d;
	}
	
	public String getLinha() {
		return operacao + ": " + valor + " Saldo: " + saldo + " Data: " + getDate() + "\n";
	}

	public String getOperacao() {

		return operacao;
	}
	public String getDate(){
		return date.getDate() + "/" + (date.getMonth()+1) + "/" + (date.getYear()+1900);
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
