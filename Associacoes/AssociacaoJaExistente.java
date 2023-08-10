public class AssociacaoJaExistente extends Exception {
    private String str = new String();
    public AssociacaoJaExistente(){
        str = "Associação já existente!";
    }
}
