package aa.com.resource.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import aa.com.resource.dao.UserDemoDAO;
import aa.com.resource.model.UserDemo;
import aa.com.resource.service.IUserDemo;
import aa.com.resources.utils.Log;
@SuppressWarnings("deprecation")
@Controller
public class UserDemoController {
	@Resource(name="iuserManager")
	private IUserDemo iUserDemo;

	@RequestMapping("/login")
	public String toLogin() {
		UserDemo userDemo = new UserDemo();
		userDemo.setName("1111");
		List<UserDemo> list = iUserDemo.findAll();
		iUserDemo.insert(userDemo);
	//	System.out.println(list.get(0).getClass());

		//Log.info("return log");
		return "login";

	}

	public IUserDemo getiUserDemo() {
		return iUserDemo;
	}

	public void setiUserDemo(IUserDemo iUserDemo) {
		this.iUserDemo = iUserDemo;
	}
	
}
