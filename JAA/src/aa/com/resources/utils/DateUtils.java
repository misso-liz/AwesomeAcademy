package aa.com.resources.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils
{
  public static final String YYYYMMDD = "yyyy-MM-dd";
  
  public static String getCurrentDate(String dateFormat)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(new Date());
  }
  
  public static String getCountDate(int hour, int minute)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.add(10, hour);
    cal.add(12, minute);
    Date date = cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    return sdf.format(date);
  }
  
  public static boolean compareDate(String date1, String date2, String dateFormat)
  {
    boolean result = false;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    try
    {
      Date dt1 = sdf.parse(date1);
      Date dt2 = sdf.parse(date2);
      if (dt1.getTime() >= dt2.getTime()) {
        result = true;
      }
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return result;
  }
  
  public static String getDateEndInt(int day)
  {
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(5, day);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(cal.getTime());
  }
  
  public static String getDateStr(String datetime, String dateFormat)
  {
    String result = "";
    if ((datetime != null) && (!"".equals(datetime))) {
      try
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        result = sdf.format(sdf.parse(datetime));
      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
    }
    return result;
  }
  
  public static long getDayNumber(String startData, String endData)
  {
    long day = 0L;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    try
    {
      Date dt1 = sdf.parse(startData);
      Date dt2 = sdf.parse(endData);
      day = (dt2.getTime() - dt1.getTime()) / 86400000L;
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return day;
  }
  
  public static java.sql.Date testDateFormat(String dfstr){
	  
	 if (StringUtils.isEmpty(dfstr)){
		 return null;
	 }
	 
	 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	 try {
		return new java.sql.Date(df.parse(dfstr).getTime());
	} catch (ParseException e) {
	   return  null;
	}
	  
  }
  
  public static void main(String[] args)
  {
    Date d = new Date();
    System.out.println(d.toLocaleString());
  }
}





