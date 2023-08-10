public class ReuniaoJaExistente extends Exception {
    private String exc = new String();
    public ReuniaoJaExistente(){
        exc = "Reunião já existente!";
    }
}
