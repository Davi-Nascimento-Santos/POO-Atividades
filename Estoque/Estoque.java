import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    //Método auxiliar para pesquisar produtos
    public Produto pesquisa(int cod){
        for (Produto p: produtos){
            if (p.getCod() == cod){
                return p;
            }
        }
        return null;
    }

    //Método para Incluir produtos
    public void incluir(Produto p){
        Produto prod = this.pesquisa(p.getCod());
        if (prod  == null && p.getCod() > 0 && p.getDescricao().isBlank() == false && p.getEstoqueMinimo() >= 0 && p.getLucro() >=0 && p.getFornecedor().getNome() != null && p.getFornecedor().getNome().isBlank() ==false && p.getFornecedor().getCnpj() > 0){
            produtos.add(p);
        }
    }

    ///Método para ver a quantidade de produtos
    public int quantidade(int cod){
        Produto prod = pesquisa(cod);
        if (prod != null){
            return prod.getQuant();
        }
        return 0;
    }

    //Método para vender um produto
    public double vender(int cod, int quant){
        Produto prod = pesquisa(cod);
        if (prod == null){
            return -1;
        }else if(quant <= 0){
            return 0;
        }
        return prod.venda(quant);
    }

    //Método para comprar um produto
    public void comprar(int cod, int quant, double preco){
        Produto prod = pesquisa(cod);
        if (prod != null && quant >0 && preco > 0){
            prod.compra(quant, preco);
        }
    }

    //Método para pesquisar um fornecedor
    public Fornecedor fornecedor(int cod){
        Produto prod = pesquisa(cod);
        if (prod != null){
            return prod.getFornecedor();
        }
        return null;
    }

    public Produto[] estoqueAbaixoDoMinimo(){
        ArrayList<Produto> prod = new ArrayList<Produto>();
        for (Produto p: produtos){
            if (p.abaixoDoMinimo()){
                prod.add(p);;
            }
        }
        Produto[] prods = new Produto[prod.size()];
        for (int i=0; i<prod.size(); i++){
            prods[i]= prod.get(i);
        }
        return prods;
    }
}
