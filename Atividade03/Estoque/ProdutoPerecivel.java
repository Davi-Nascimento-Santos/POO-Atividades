import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class ProdutoPerecivel extends Produto{
    private ArrayList<Lote> lotes = new ArrayList<Lote>();

    public ProdutoPerecivel(int cod, String desc, int min, double lucro, Fornecedor forn) {
        super(cod, desc, min, lucro, forn);
    }

    //Método para compra
    public boolean compra(int quantidade, double val, Date data){
        if (quantidade > 0 && val > 0 && data != null){
            //Verifica se o lote já está vencido
            Date hoje = new Date(); 
            if (data.before(hoje)){
                return false;
            }
             //Atualiza o preco de compra do produto
            this.precoCompra = (this.quant * this.precoCompra + quant * val) / (this.quant + quant);
            //Atualiza o preco de venda do produto
            this.precoVenda = (this.precoCompra * this.lucro) + this.precoCompra;
            //Atualiza a quantidade de produtos
            this.quant += quantidade;
            //Coloca um lote no produto
            Lote l = new Lote(quantidade, data);
            this.lotes.add(l);
            return true;
        }
        return false;
    }

    //Método para verificar se o produto é válido
    private boolean loteValido(Lote l){
        Date today = new Date();
        return l.getDataValidade().before(today);
    }

    //Método para verificar quantos produtos válidos há
    public int quantidadeProdutosValidos(){
        int quantidadeProdutos = 0;
        for (Lote l: this.lotes){
            if (loteValido(l)){
                quantidadeProdutos += l.getQuantidade();
            }
        }
        return quantidadeProdutos;
    }


    public boolean produtoVencido(){
        Date today = new Date();
        for (Lote l: lotes){
            if (l.getDataValidade().after(today)){
                return true;
            }
        }
        return false;
    }
    //Método de venda
    /*public void venda(int quant){
        if (quant <= quantidadeProdutosValidos() && quant > 0){
            Date min = new Date();
            for (int i=0; i < lotes.size(); i++){
                if (i==0){
                    
                    min = lotes.get(i).getDataValidade();
                } else if (lotes.get(i).getDataValidade().before(min)){
                        min = lotes.get(i).getDataValidade();
                    }
                }
            }

        }
    }*/


    

    
}
