public class TesteAssociacaoDAO {
    public static void main(String[] args) throws AssociacaoJaExistente, ValorInvalido {
        Associacao a = new Associacao(1, "ADUFPI");
        Associacao b = new Associacao(2, "APACHE");
        Associacao c = new Associacao(3, "AABB");
        AssociacaoDAO associacaoDAO = new AssociacaoDAO();
        associacaoDAO.adicionar(a);
    }
}
