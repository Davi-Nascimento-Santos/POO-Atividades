package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;

class ContaComumTest {

	@Test
	void testarCreditoEDebito() {
		Pessoa p = new Pessoa(1);
		p.setNome("Pedro");
		ContaComum c = new ContaComum(100, p);
		
		c.credito(1000);
		assertEquals(1000, c.getSaldo());
		
		c.debito(10);
		assertEquals(990, c.getSaldo());
	}
	
	@Test
	void testarUsoDeNumerosGrandes() {
		Pessoa p = new Pessoa(1);
		p.setNome("Pedro");
		ContaComum c = new ContaComum(100, p);

		c.setNum(101);
		assertEquals(101, c.getNum());
		
		c.setNum(1001);
		assertEquals(102, c.getNum());
	}
	
	@Test
	void testarExtrato() {
		Pessoa p = new Pessoa(1);
		p.setNome("Pedro");
		ContaComum c = new ContaComum(100, p);

		c.credito(1000);		
		c.debito(10);
		String extrato = "Credito: 1000.0 Saldo: 1000.0 Data: 19/5/2023\nDebito: 10.0 Saldo: 990.0 Data: 19/5/2023\n";
		assertEquals(extrato, c.getExtrato());
	}
	
	@Test
	void testarDebitoAcimaDoLimite() {
		Pessoa p = new Pessoa(1);
		p.setNome("Pedro");
		ContaComum c = new ContaComum(100, p);
		
		c.debito(1);
		assertEquals(0, c.getSaldo());
		
		c.credito(1000);
		assertEquals(1000, c.getSaldo());
		
		c.debito(1001);
		assertEquals(1000, c.getSaldo());
	
		c.debito(1000);
		assertEquals(0, c.getSaldo());
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
		d.setMonth(dt[1]);
		d.setYear(dt[2]);
		return d;

	}
	@Test
	void testarDataEntreDuasDatas() {
		int[] dti = {1, 1, 221};
		int[] dta = {10, 2, 222};
		int[] dtf = {1, 3, 222};
		Date di = setData(dti);
		Date da = setData(dta);
		Date df = setData(dtf);
		assertEquals(true, dataEntre(di, da, df));
	}
	@Test
	void testarDataMaior() {
		int[] dti = {10, 10, 2021};
		int[] dta = {10, 10, 2022};
		Date di = setData(dti);
		Date da = setData(dta);
		assertEquals(true, dataMenor(di, da));
	}

	@Test
	void testarDataMenor() {
		int[] dtf = {2, 2, 2021};
		int[] dta = {1, 2, 2021};
		Date da = setData(dta);
		Date df = setData(dtf);
		assertEquals(true, dataMaior(df, da));
	}

}
