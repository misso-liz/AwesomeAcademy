package aa.com.resources.utils;

public class Singlton {
	private static Singlton single = new Singlton();
	public static int new_Status = 1;
	public static int dis_Status = 1;
	Singlton(){}
	public static  Singlton getSingle(){
		return single;
	}

}
