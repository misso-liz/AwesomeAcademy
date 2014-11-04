package aa.com.resources.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utils {
	
	
	public static String format(Object o){
		
		if(o==null)
			return "";
		
		if (o instanceof java.util.Date) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(o instanceof java.sql.Timestamp)
			  df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			return df.format(o);
		}
		
		return o.toString();
	}
	
	
	

}
