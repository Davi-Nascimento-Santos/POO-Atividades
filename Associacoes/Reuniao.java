import java.util.ArrayList;
import java.util.Date;

public class Reuniao {
    protected String ata;
    protected Date data;
    protected ArrayList<Associado> participantes = new ArrayList<Associado>();
    public Reuniao(long data, String ata) {
        Date dt = new Date(data);
        this.ata = ata;
        this.data = dt;
    }

    public Associado pesquisarParticipante(Associado a){
        for (Associado ass: participantes){
            if (a.getNumero()==ass.getNumero()){
                return ass;
            }
        }
        return null;
    }

    public void adicionarParticante(Associado a) throws FrequenciaJaRegistrada{
        if (pesquisarParticipante(a)==null){
            participantes.add(a);
        }else{
            throw new FrequenciaJaRegistrada();
        }
    }

    public String getAta() {
        return ata;
    }
    public Date getData() {
        return data;
    }
    
    
    
}
