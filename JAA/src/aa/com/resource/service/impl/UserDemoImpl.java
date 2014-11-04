package aa.com.resource.service.impl;

import java.util.List;

import aa.com.resource.dao.UserDemoDAO;
import aa.com.resource.model.UserDemo;
import aa.com.resource.service.IUserDemo;

public class UserDemoImpl  implements IUserDemo{
	
	private UserDemoDAO userDemoDAO;

	public List<UserDemo> findAll(){
		return userDemoDAO.findAll();
	}
	
	public void insert(UserDemo userDemo) {
		 userDemoDAO.merge(userDemo);
		 userDemoDAO.findAll();
		 System.out.println(userDemoDAO.findAll());
		
	}
	public UserDemoDAO getUserDemoDAO() {
		return userDemoDAO;
	}

	public void setUserDemoDAO(UserDemoDAO userDemoDAO) {
		this.userDemoDAO = userDemoDAO;
	}
	
	
	
}
