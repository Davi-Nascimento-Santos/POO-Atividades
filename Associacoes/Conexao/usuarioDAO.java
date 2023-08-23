package Conexao;

import conexao;

public class usuarioDAO {
    public void cadastrar(Usuario u){
        String sql = "INSERT INTO usuario (nome, email, senha, login) VALUES (?, ?, ?, ?)";
        try{
            java.sql.PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getLogin());
            ps.executeUpdate();
            System.out.println("Cadastrado com sucesso!");
        }catch(Exception e){
            System.out.println("Erro ao cadastrar: "+e.getMessage());
        }
    } 
}
