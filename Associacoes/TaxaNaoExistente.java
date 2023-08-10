public class TaxaNaoExistente extends Exception {
    private String exc = new String();
    public TaxaNaoExistente(){
        exc = "Taxa não existente!";
    }

}
