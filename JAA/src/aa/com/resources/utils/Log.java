package aa.com.resources.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public final class Log {
	
	 private static Logger logger = LogManager.getLogger(Log.class);
	 
	 
	 public static void info(String infostr){
		 
		 if(logger.isInfoEnabled()){
			 logger.info(infostr);
		 }
		 
	 }
	 
	 public static void debug(String debugstr){
		 
		 if(logger.isDebugEnabled()){
			 logger.debug(debugstr);
		 }
		 
		 
	 }
	 
	 
	 public static void error(String errorstr){
		 if(logger.isInfoEnabled()){
			 logger.error(errorstr);
		 }
	 }
	 
	 
	 public static void fatal(String fatalstr){
		 if(logger.isInfoEnabled()){
			 logger.fatal(fatalstr);
		 }
	 }
	
	 
	 public static Logger getLogger(Class<?> cls){
		 
		 return LogManager.getLogger(cls);
	 }

}
