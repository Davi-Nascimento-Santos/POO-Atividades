import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.runner.notification.StoppedByUserException;

public class teste {
    public static void main(String[] args) {
		Estoque estoque = new Estoque();
		Fornecedor forn1 = new Fornecedor(48, "Unilever");
		Fornecedor forn2 = new Fornecedor(19, "Gilette");
		Fornecedor forn3 = new Fornecedor(33, "Nestle");
		Fornecedor forn4 = new Fornecedor(24, "Ambev");
		Produto prod1 = new Produto(12, "Shampoo", 5, 2, forn1);
		Produto prod2 = new Produto(13, "Aparelho de Barbear", 5, 1, forn2);
		Produto prod3 = new ProdutoPerecivel(14, "Sorvete", 5, 2, forn3);
		Produto prod4 = new ProdutoPerecivel(15, "Cerveja", 5, 1, forn4);
		Date data = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
		data.setTime(data.getTime() + 120000);
		
		estoque.incluir(prod1);
		estoque.incluir(prod2);
		estoque.incluir(prod3);
		estoque.incluir(prod4);
		estoque.comprar(prod1.getCodigo(), 10, 5, null);
		estoque.comprar(prod2.getCodigo(), 10, 2.5, null);
		estoque.comprar(prod3.getCodigo(), 10, 5, data);
		estoque.comprar(prod4.getCodigo(), 20, 2.5, data);
		estoque.vender(12, 9);
		estoque.vender(13, 1);
		estoque.vender(14, 2);
		estoque.vender(15, 18);
		ArrayList<Produto> abaixoMinActual = estoque.estoqueAbaixoDoMinimo();
        System.out.println(abaixoMinActual.size());
		if (2 == abaixoMinActual.size()){
            System.out.println("Deu certo!");
        }
		for (Produto produto : abaixoMinActual) {
			if (produto == prod1 || produto == prod4){
                System.out.println("Acertou!");
            }
		}
        
    }
    
}
