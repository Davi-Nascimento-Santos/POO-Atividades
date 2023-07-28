import java.util.ArrayList;
import java.util.Date;

public class Reuniao {
    protected Date data;
    protected String ata;
    protected ArrayList<Associado> participantes = new ArrayList<Associado>();
    public Reuniao(Date data, String ata){
        this.data=data;
        this.ata=ata;
    }
}
