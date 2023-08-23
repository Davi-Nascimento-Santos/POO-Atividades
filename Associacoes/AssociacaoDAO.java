import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AssociacaoDAO{
    public void adicionar(Associacao a) throws AssociacaoJaExistente, ValorInvalido{
        Connection con;
        if (a != null){
            if (a.getNome()!=null && a.getNome().isBlank()!=true && a.getNome().isEmpty()!=true && a.getNumero() > 0){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "password");
                    Statement stmt = con.createStatement();
                    String comando = "insert into Associacao (numero, nome) values (" + a.getNumero() + ", '" + a.getNome() + "');";
                    stmt.execute(comando);
                }catch(Exception e){
                    throw new AssociacaoJaExistente();
                }
            }else{
                throw new ValorInvalido();
            }
        }
    }

    /*public void adicionar(int num, Taxa t) throws TaxaJaExistente{
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "@Davi19072001");
            Statement stmt = con.createStatement();
            String comando = "insert into Taxa (nome, vigencia, valorAno, parcelas, administrativa) values (" + t.getNome() + ", '" + t.getVigencia() + "', '" + t.getValorAno() + "', '" + t.getParcelas() + "', '" + t.isAdministrativa() + "');";
            stmt.execute(comando);
            String pesquisaNumTaxa = "select * from Taxa where nome = '" + t.getNome() + "' and vigencia = " + t.getVigencia();
            ResultSet resultado2 = stmt.executeQuery(pesquisaNumTaxa);
            if (resultado2.next()){
                int numTaxa = resultado2.getInt("idTaxa");
                String insercaoRelacao = "insert into relacaoAssociacaoTaxa (codAssociacao, codTaxa) values (" + num + ", " + numTaxa + ");";
                try{
                    stmt.execute(insercaoRelacao);
                }catch(Exception e){
                    throw new TaxaJaExistente();
                }
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }*/

    public Associacao pesquisarAssociacao(int numero){
        Associacao a = null;
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "password");
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinhaAssociacao", "root", "password");
            String comando = "delete from Associacao";
            Statement stmt = con.createStatement();
            stmt.execute(comando);
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
