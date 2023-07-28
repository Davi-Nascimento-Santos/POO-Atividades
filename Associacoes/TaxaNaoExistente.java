public class TaxaNaoExistente extends Exception {
    String exc = new String();
    public TaxaNaoExistente(){
        exc = "Taxa não existente!";
    }
}
