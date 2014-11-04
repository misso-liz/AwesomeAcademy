package aa.com.resources.utils;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public final class  LogUtils extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(LogUtils.class);
	private static LogUtils logUtils = null;
//	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
//		
//	}
	private LogUtils(){
		Properties log4jConf = new Properties(); 
	       try {
				log4jConf.load(LogUtils.class.getResourceAsStream("/config/properties/myLog4j.properties"));
	       } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	       } 
		    PropertyConfigurator.configure(log4jConf);
//		  //PropertyConfigurator.configure("/config/properties/myLog4j.properties");
//		    logger.debug("Here is DEBUG messgae");
//		    logger.info("Here is INFO message");
//		    logger.warn("Here is WARN message");
//		    logger.error("Here is ERROR message");
//		    logger.fatal("Here is FATAL message");

	}
	
	private static LogUtils getInstance() { 
      
		if(logUtils==null){
			logUtils=new LogUtils();
		}
		return logUtils;
       
	}
	public static void info (String info){
		logger.info(info);
	}
	
	public static void debug(String debug){
		logger.debug(debug);
	}
	public static void error(String error){
		logger.error(error);
	}
	public static void fatal(String fatal){
		logger.fatal(fatal);
	}
}
