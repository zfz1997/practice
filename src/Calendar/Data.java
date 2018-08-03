package Calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Data {
	public static void main(String[] args) {
		GregorianCalendar calendar=new GregorianCalendar();
		Date date=calendar.getTime();
	    
	    DateFormat Df=DateFormat.getDateTimeInstance(DateFormat.FULL,0,  new Locale("zh","CN"));
	    System.out.println(Df.format(date));
	    
	    SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH");
	    System.out.println(sd.format(date));
	    
	}
}