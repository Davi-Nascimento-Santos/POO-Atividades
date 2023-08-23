import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class AssociacaoDAO{
    public void cadastrar(Associacao a) throws AssociacaoJaExistente{
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "@Davi19072001");
            String pesquisa = "select * from Associacao where numero = " + a.getNumero();
            Statement stmt = con.createStatement();
            ResultSet resultado  = stmt.executeQuery(pesquisa);
            if(resultado.next()){
                int numero = resultado.getInt("numero");
                if (numero == a.getNumero()){
                    throw new AssociacaoJaExistente();
                }
            }
            String comando = "insert into Associacao (numero, nome) values (" + a.getNumero() + ", '" + a.getNome() + "')";
            stmt.execute(comando);
        }catch(Exception e){
            System.out.println(new AssociacaoJaExistente());
        }
    }

    public Associacao pesquisarAssociacao(int numero){
        Associacao a = null;
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "@Davi19072001");
            String pesquisa = "select * from Associacao where numero = " + numero;
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(pesquisa);
            if(resultado.next()){
                int numeroAssociacao = resultado.getInt("numero");
                String nome = resultado.getString("nome");
                a = new Associacao(numeroAssociacao, nome);
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return a;

    }

    public void removerTodos(){
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "@Davi19072001");
            String comando = "delete from Associacao";
            Statement stmt = con.createStatement();
            stmt.execute(comando);
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
