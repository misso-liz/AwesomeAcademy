package aa.com.resources.utils;

import java.io.PrintStream;
import java.util.UUID;

public class UUIDGeneratorUtils
{
  public static String getUUID()
  {
    UUID uuid = UUID.randomUUID();
    String str = uuid.toString();
    return str;
  }
  
  public static String[] getUUID(int number)
  {
    if (number < 1) {
      return null;
    }
    String[] ss = new String[number];
    for (int i = 0; i < number; i++) {
      ss[i] = getUUID();
    }
    return ss;
  }
  
  public static void main(String[] args)
  {
    System.out.println(getUUID());
  }
}





