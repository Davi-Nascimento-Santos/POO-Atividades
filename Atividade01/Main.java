public class Main {
    public static void main(String[] args) {
        Pessoa davi = new Pessoa(2485539, "Davi");
        Conta contaDavi = new Conta(1234, davi);
        System.out.println(contaDavi.getDono());
        contaDavi.Credito(100);
        contaDavi.Credito(150);
        contaDavi.Debito(250);
        contaDavi.getExtrato(1);
    }
}
