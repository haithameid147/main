package com.youtube.jwt.controller;

import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.annotation.PostConstruct;

//@CrossOrigin(origins = "http://10.101.0.80:4200")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();

	}

	@PostMapping({ "/registerNewUser" })
	public boolean registerNewUser(@RequestBody User user) {
		boolean isExist = userService.userNameCheck(user.getUserName());
		if (!isExist) {
			System.out.println(isExist);
			userService.registerNewUser(user);
			return true;
		} else {
			System.out.println(isExist);

			return false;
		}
	}

	@PutMapping("/addUser/{id}")
	public String ubdateUser(@PathVariable String id, @RequestBody User user) {
		System.out.println("getUserByUserName update " + id);
		User useer = new User();
		user = userService.findById(id);
		String useerPass = user.getUserPassword();
		user.setUserPassword(useerPass);
		System.out.println("password update " + useerPass);

		userService.ubdate(user);
		return "Services ubdate";
	}

	@PutMapping("/updateUserField/{username},{firstname},{lastname},{mobile}/user")
	public void updateUserField(@PathVariable String username, @PathVariable String firstname,
			@PathVariable String lastname, @PathVariable String mobile) {
		userService.updateUserField(username, firstname, lastname, mobile);
	}

	@PutMapping("/updatePassword/{username},{password}/user")
	public void updatePassword(@PathVariable String username, @PathVariable String password) {
		System.out.print("kdhsfk");
		userService.updatePassword(username, password);
	}

	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accessible to the admin";
	}

	@GetMapping({ "/getUserByUserName/{name}" })
	public User getUserByUserName(@PathVariable String name) {
		System.out.println("getUserByUserName");
		System.out.println("getUserByUserName" + userService.findById("admin"));
		User user = new User();

		user = userService.findById(name);

		// user.setUserPassword(getEn("admin"));

		return user;
	}

	@GetMapping({ "/forUser" })
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only accessible to the user";
	}

}
