public class TesteAssociacaoDAO {
    public static void main(String[] args) throws AssociacaoJaExistente {
        new AssociacaoDAO().removerTodos();

        Associacao a = new Associacao(1, "ADUFPI");
        Associacao b = new Associacao(2, "APACHE");
        Associacao c = new Associacao(3, "AABB");
        AssociacaoDAO associacaoDAO = new AssociacaoDAO();
        associacaoDAO.cadastrar(a);
        associacaoDAO.cadastrar(b);
        associacaoDAO.cadastrar(c);
        Associacao r = associacaoDAO.pesquisarAssociacao(2);
        System.out.println(r.getNome());
        System.out.println(r.getNumero());

        Associacao p = associacaoDAO.pesquisarAssociacao(3);
        System.out.println(p.getNome());
        System.out.println(p.getNumero());
    }
}
