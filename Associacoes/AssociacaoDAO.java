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
