public class TaxaJaExistente extends Exception {
    private String exc = new String();
    public TaxaJaExistente(){
        exc = "Taxa já existente!";
    }

}
