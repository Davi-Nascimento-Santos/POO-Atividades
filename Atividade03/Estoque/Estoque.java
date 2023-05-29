public class Estoque {
    private Produto[] produtos = new Produto[100];
    private int quant = 0;

    //Método auxiliar para pesquisar produtos
    public Produto pesquisa(int cod){
        for (int i=0; i< this.quant; i++){
            if (this.produtos[i].getCod() == cod){
                return this.produtos[i];
            }
        }
        return null;
    }

    //Método para Incluir produtos
    public boolean incluir(Produto p){
        Produto prod = this.pesquisa(p.getCod());
        if (prod  == null){
            this.produtos[this.quant] = p;
            this.quant++;
            return true;
        }
        return false;
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
        }
        return prod.venda(quant);
    }

    //Método para comprar um produto
    public void comprar(int cod, int quant, double preco){
        Produto prod = pesquisa(cod);
        if (prod != null){
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
        int cont = 0; 
        for (int i=0; i< this.quant; i++){
            if (this.produtos[i].abaixoDoMinimo()){
                cont++;
            }
        }
        Produto prods[] = new Produto[cont];
        int posi = 0;
        for (int i=0; i< this.quant; i++){
            if (this.produtos[i].abaixoDoMinimo()){
                prods[posi]=this.produtos[i];
                posi++;
            }
        }
        return prods;
    }
}
