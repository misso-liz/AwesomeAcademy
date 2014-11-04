package aa.com.resource.service;

import java.util.List;

import aa.com.resource.model.UserDemo;

public interface IUserDemo {
	public List<UserDemo> findAll();
	public void insert(UserDemo userDemo);
}
