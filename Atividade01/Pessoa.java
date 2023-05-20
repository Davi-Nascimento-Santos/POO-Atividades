public class Pessoa {
    private int cpf;
    private String nome;
    private Conta conta;
    
    public Pessoa(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    public int getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        if (this.conta == null){
            this.conta = conta;
        }else{
            System.out.println("ERRO! Não é pertido alterar a conta dessa pessoa!");
        }
    }
    
    
}
