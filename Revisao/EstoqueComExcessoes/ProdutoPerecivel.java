import java.util.ArrayList;
import java.util.Date;

public class ProdutoPerecivel extends Produto{
    private ArrayList<Lote> lotes = new ArrayList<Lote>();

    public ProdutoPerecivel(int cod, String desc, int min, double lucro, Fornecedor forn) {
        super(cod, desc, min, lucro, forn);
    }

    //Método para compra
    public void compra(int quantidade, double val, Date data){
        Date hoje = new Date();
        //Verifica se o lote já está vencido
        if (data.after(hoje)){
            //Atualiza o preco de compra do produto
            super.precoCompra = (super.quant * super.precoCompra + quantidade * val) / (super.quant + quantidade);
            //Atualiza o preco de venda do produto
            super.precoVenda = (super.precoCompra * super.lucro) + super.precoCompra;
            //Atualiza a quantidade de produtos
            this.quant += quantidade;
            //Coloca um lote no produto
            Lote l = new Lote(quantidade, data);
            this.lotes.add(l);
        }
    }

    //Método para verificar se o produto é válido
    public boolean loteValido(Lote l){
        Date today = new Date();
        return l.getDataValidade().after(today);
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

    //Método para verificar se o estoque tá abaixo do mínimo
    public boolean abaixoDoMinimo(){
        int quantidade = 0;
        for (Lote l: lotes){
            quantidade+= l.getQuantidade();
        }
        if (quantidade < super.estoqueMinimo){
            return true;
        }
        return false;
    }

    //Método para verificar quantos produtos vencidos tem
    public int quantideVencidos(){
        int quantidade = 0;
        Date today = new Date();
        for (Lote l: lotes){
            if (l.getDataValidade().before(today)){
                quantidade+= l.getQuantidade();
            }
        }
        return quantidade;
    }

    //Método para verificar se um produto é vencido.
    public boolean produtoVencido(){
        Date today = new Date();
        for (Lote l: lotes){
            if (l.getDataValidade().before(today)){
                return true;
            }
        }
        return false;
    }
    
    //Método de venda
    public double venda(int quant){
        int  quantidadeProd = quant;
        if (quant <= quantidadeProdutosValidos()){
            for (Lote l: lotes){
                if (loteValido(l)){
                    if (quant == l.getQuantidade()){
                        quant = 0;
                        l.setQuantidade(0);
                    }else if (quant > l.getQuantidade() && l.getQuantidade() > 0){
                        quant -= l.getQuantidade();
                        l.setQuantidade(0);
                    }else{
                        l.setQuantidade(l.getQuantidade() - quant);
                        quant = 0;
                    }
                }
                if (quant == 0){
                    break;
                }
            }
            return quantidadeProd * super.getPrecoVenda();
        }
        return -1;
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    
}
