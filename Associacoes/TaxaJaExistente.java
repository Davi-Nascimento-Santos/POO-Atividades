public class TaxaJaExistente extends Exception {
    String exc = new String();
    public TaxaJaExistente(){
        exc = "Taxa já existente!";
    }
}
