import java.util.Arrays;
public class teste {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
		Fornecedor forn1 = new Fornecedor(48, "Nestle");
		Fornecedor forn2 = new Fornecedor(19, "Ambev");
		Produto prod1 = new Produto(12, "Sorvete", 5, 1, forn1);
		Produto prod2 = new Produto(15, "Cerveja", 5, 1, forn2);
		Produto prod3 = new Produto(18, "Cerveja Pilsen", 5, 1, forn2);
		estoque.incluir(prod1);
		estoque.incluir(prod2);
		estoque.incluir(prod3);
		estoque.comprar(12, 3, 5);
		estoque.comprar(15, 1, 10);
		estoque.comprar(18, 5, 8);
		Produto[] produtos = {prod1, prod2};
		Produto[] produtosAbaixoDoMinimo = estoque.estoqueAbaixoDoMinimo();
		System.out.println(Arrays.equals(produtos, produtosAbaixoDoMinimo));
    }
    
}
