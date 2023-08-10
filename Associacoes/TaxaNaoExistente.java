public class TaxaNaoExistente extends Exception {
    private String str = new String();
    public TaxaNaoExistente(){
        str = "Taxa não existente!";
    }

}
