package aa.com.resource.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import aa.com.resource.model.User;
import aa.com.resources.utils.Log;

/**
 * 
 * @author fql
 * 
 *         
 *     
 */

@SuppressWarnings("deprecation")
@Controller
public class UserController 
{
	  @RequestMapping("/login")

	    public String toLogin() {
		  User user = new User();

		  Log.info("return log");
	       return "login";
	       


	}
	  @RequestMapping("/pass")
	  public String pass() {
		//  User user = new User();
		  Log.info("return log");
	       return "login";
	       


	}

	



	 

	  


}