package banco;

import java.util.Date;

public class CriarData {
    public Date dt = new Date();
    public CriarData(int[] d){
        dt.setDate(d[0]);
		dt.setMonth(d[1]-1);
		dt.setYear(d[2]-1900);        
    }
    public Date getDt(){
        return this.dt;
    }
    
}
