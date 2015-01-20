package demo.service;

import demo.model.User;

public interface UserService {
	void save(User user);
	
	void delete(String name);
	
	User getByName(String name);
}
