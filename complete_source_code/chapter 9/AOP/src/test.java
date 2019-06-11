import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        String str= "12:30";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            Date date = format.parse(str);
            System.out.println(date);
        }
        catch (ParseException exc)
        {

        }
    }
}
