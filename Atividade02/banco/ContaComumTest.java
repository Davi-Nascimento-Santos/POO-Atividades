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

	@Test
	public void testeGetExtratoComDatas() {
		Pessoa p = new Pessoa(1);
		p.setNome("Pedro");
		ContaComum c = new ContaComum(100, p);

		c.credito(1000);		
		c.debito(10);
		c.credito(1000);
		c.debito(500);
		int[] di = {19, 6, 2023};
		int[] df = {22, 7, 2023};
		CriarData dataInicio = new CriarData(di);
		CriarData dataFim = new CriarData(df);
		System.out.println(c.getExtrato(dataInicio.getDt(), dataFim.getDt()));
	}

}
