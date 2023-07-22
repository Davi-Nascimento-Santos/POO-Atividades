import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class teste {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Fornecedor forn1 = new Fornecedor(33, "Nestle");
        Fornecedor forn2 = new Fornecedor(24, "Ambev");
        Produto prod1 = new ProdutoPerecivel(14, "Sorvete", 5, 2, forn1);
        Produto prod2 = new ProdutoPerecivel(15, "Cerveja", 5, 1, forn2);
        Date data = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
        data.setTime(data.getTime() - 120000);

        Date hoje = new Date();
        if (data.before(hoje)){
            System.out.println("Deu certo!");
        }
    }
    
}
