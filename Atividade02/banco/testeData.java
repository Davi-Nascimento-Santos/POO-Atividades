package banco;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class testeData {
    public static void main(String[] args) {
        Date data = new Date();
        data.setDate(10);
        data.setMonth(4);
        data.setYear(123);
        System.out.println(data);
    }
    


    
}
