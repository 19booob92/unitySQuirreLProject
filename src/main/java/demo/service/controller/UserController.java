package demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.User;
import demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable String name) {
		return userService.getByName(name);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(@PathVariable String name) {
		User user = new User("1", "mateusz", "Wrocław");

		userService.save(user);

		return "saved";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public String User(@PathVariable String name) {
		userService.delete(name);

		return "deleted";
	}
}
