public class ReuniaoJaExistente extends Exception {
    private String str = new String();
    public ReuniaoJaExistente(){
        str = "Reunião já existente!";
    }
}
