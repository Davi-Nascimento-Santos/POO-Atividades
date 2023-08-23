package Conexao;

public class Teste {
    public static void main(String[] args) {
        Usuario u = new Usuario(1, "Denise", "denise@gmail.com", "123456", "denise02022005");
        new usuarioDAO().cadastrar(u);    
    }
    
}
