package banco;
import java.util.Date;
public class ContaComum {
	
	private int num;
	private double saldo;
	private Extrato[] extrato = new Extrato[100];
	private int pos = 0;
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
		Date date = new Date();
		extrato[pos++] = new Extrato("Credito", val, saldo, date);
	}
	
	public void debito(double val) {
		if (val <= saldo) { 
		  	saldo = saldo - val;
			Date date = new Date();
			extrato[pos++] = new Extrato("Debito", val, saldo, date);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	public int getNum() {
		return num;
	}
	
	public void setNum(int n) {
		if (n < 1000) { 
		  num = n;
		} else {
			System.out.println("Não é permitido usar numeros maiores que 1000");
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public String getExtrato() {
		String ext = "";
		for (int i = 0; i < pos; i++) {
			ext = ext + extrato[i].getLinha();
		}
		return ext;
	}
	
	public Pessoa getDono() {
		return dono;
	}

	public Boolean dataMenor(Date di, Date da){
		if (di.getYear() < da.getYear()){
			return true;
		}else if (di.getYear() == da.getYear()){
			if (di.getMonth() < da.getMonth()){
				return true;
			}else if (di.getMonth() == da.getMonth()){
				if (di.getDate() <= da.getDate()){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public Boolean dataMaior(Date df, Date da){
		if (df.getYear() > da.getYear()){
			return true;
		}else if (df.getYear() == da.getYear()){
			if (df.getMonth() > da.getMonth()){
				return true;
			}else if (df.getMonth() == da.getMonth()){
				if (df.getDate() >= da.getDate()){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public Boolean dataEntre(Date di, Date da, Date  df){
		if (dataMenor(di, da) && dataMaior(df, da)){
			return true;
		}else{
			return false;
		}
	}
	public Date setData(int[] dt){
		Date d = new Date();
		d.setDate(dt[0]);
		d.setMonth(dt[1]-1);
		d.setYear(dt[2]-1900);
		return d;

	}

	public String getExtrato(Date di, Date df) {
		//Date dataInicio = setData(di);
		//Date dataFim = setData(df);
		String ext = "";
		for (int i = 0; i < pos; i++) {
			if (dataEntre(di, extrato[i].getDate(), df)){
				ext = ext + extrato[i].getLinha();
			}
		}
		return ext;
	}
}
