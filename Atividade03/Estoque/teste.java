import java.util.Arrays;
public class teste {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
		Fornecedor forn1 = new Fornecedor(48, "Nestle");
		Produto prod1 = new Produto(12, "Sorvete", 5, 1, forn1);
		estoque.incluir(prod1);
		estoque.comprar(12, 20, 5);
		// Verifica se o valor total da venda est� correto
        Produto p = estoque.pesquisa(12);
        estoque.vender(12, 1);
        System.out.println(estoque.quantidade(12));
        System.out.println(p.getPrecoCompra());
		System.out.println(p.getPrecoVenda());
    }
    
}
