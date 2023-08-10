import java.util.ArrayList;
import java.util.Date;

public class Reuniao {
    protected String ata;
    protected Date data;
    protected ArrayList<Associado> participantes = new ArrayList<Associado>();
    public Reuniao(Date data, String ata) {
        this.ata = ata;
        this.data = data;
    }

    public String getAta() {
        return ata;
    }
    public Date getData() {
        return data;
    }
    
    
    
}
