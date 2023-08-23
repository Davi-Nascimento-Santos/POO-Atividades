import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class TaxaDAO {
    public void adicionar(Taxa t){
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "@Davi19072001");
            Statement stmt = con.createStatement();
            String comando = "insert into Taxa (nome, vigencia, valorAno, parcelas, administrativa) values (" + t.getNome() + ", '" + t.getVigencia() + "', '" + t.getValorAno() + "', '" + t.getParcelas() + "', '" + t.isAdministrativa() + "')";
            stmt.execute(comando);
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
