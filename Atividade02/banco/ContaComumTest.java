package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
	public Boolean dataMenor(int[] di, int[] da){
		if (di[2] < da[2]){
			return true;
		}else if (di[2] == da[2]){
			if (di[1] < da[1]){
				return true;
			}else if (di[1] == da[1]){
				if (di[0] <= da[0]){
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

	public Boolean dataMaior(int[] df, int[] da){
		if (df[2] > da[2]){
			return true;
		}else if (df[2] == da[2]){
			if (df[1] > da[1]){
				return true;
			}else if (df[1] == da[1]){
				if (df[0] >= da[0]){
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

	@Test
	void testarDataMaior() {
		int[] di = {10, 10, 2021};
		int[] da = {10, 10, 2022};
		assertEquals(true, dataMenor(di, da));
	}

	@Test
	void testarDataMenor() {
		int[] df = {0, 2, 2021};
		int[] da = {1, 2, 2021};
		assertEquals(true, dataMaior(df, da));
	}

}
