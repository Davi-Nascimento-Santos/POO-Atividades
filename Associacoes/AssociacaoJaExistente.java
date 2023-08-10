public class AssociacaoJaExistente extends Exception {
    private String exc = new String();
    public AssociacaoJaExistente(){
        exc = "Associação já existente!";
    }
}
