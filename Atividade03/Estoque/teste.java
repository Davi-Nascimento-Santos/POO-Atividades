import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class teste {
    public static void main(String[] args) {
		Estoque estoque = new Estoque();
		Fornecedor forn1 = new Fornecedor(48, "Unilever");
		Fornecedor forn2 = new Fornecedor(24, "Ambev");
		Produto prod1 = new Produto(12, "Shampoo", 5, 2, forn1);
		Produto prod2 = new ProdutoPerecivel(15, "Cerveja", 5, 1, forn2);
		Date data = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
		data.setTime(data.getTime() + 120000);
		
		estoque.incluir(prod1);
		estoque.incluir(prod2);
		estoque.comprar(prod1.getCodigo(), 10, 5, null);
		estoque.comprar(prod1.getCodigo(), 10, 2.5, null);
		estoque.comprar(prod1.getCodigo(), 10, 7.5, null);
		estoque.comprar(prod2.getCodigo(), 5, 2.5, data);
		estoque.comprar(prod2.getCodigo(), 5, 1.25, data);
		estoque.comprar(prod2.getCodigo(), 5, 3.75, data);
        //System.out.println(((ProdutoPerecivel)prod2).quantidadeProdutosValidos());
        //System(3*5 == estoque.vender(15, 3));
        //System.out.println(((ProdutoPerecivel)prod2).getQuant());
        
    }
    
}
