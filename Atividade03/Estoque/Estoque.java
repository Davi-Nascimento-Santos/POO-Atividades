public class Estoque {
    private Produto[] produtos = new Produto[100];
    private int quant = 0;

    //Método para Incluir produtos
    public void incluir(Produto p){
        for (int i=0; i< this.quant; i++){
            if (this.produtos[i].getCod() == p.getCod()){
                break;
            }
        }
        this.produtos[this.quant] = p;
    }

    ///Método para ver a quantidade de produtos
    public int quantidade(){
        return this.quant;
    }

    //Método para vender um produto
    public double vender(int cod, int quant){
        if (quant > 0){
            for (int i=0; i < this.quant; i++){
                if (this.produtos[i].getCod() == cod){
                    double resposta = this.produtos[i].venda(quant);
                    return resposta;
                }
            }
        }else{
            return -1;
        }
    }

    //Método para pesquisar um fornecedor
    public Fornecedor fornencedor(int cod){
        for (int i=0; i< this.quant; i++){
            if (this.produtos[i].getCod() == cod){
                return this.produtos[i].getFornecedor();
            }
        }
        return null;
    }
}
