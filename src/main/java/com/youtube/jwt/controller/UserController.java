package com.youtube.jwt.controller;

import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.UserService;
import com.youtube.jwt.service.emailSendMessege;

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
import java.util.Random;

import javax.annotation.PostConstruct;

//@CrossOrigin(origins = "http://10.101.0.80:4200")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class UserController {

	@Autowired
	private UserService userService;
    @Autowired
    private emailSendMessege sendEmail ;
    int min = 1000;  
	int max = 9999;
   
	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();

	}

	@PostMapping({ "/registerNewUser" })
	public boolean registerNewUser(@RequestBody User user) {
		boolean isExist = userService.userNameCheck(user.getUserName());
		if (!isExist) {
			//System.out.println(isExist);
//			int min = 1000;  
//			int max = 9999;
			int randomWithNextInt = (int)(Math.random()*(max-min+1)+min);
			user.setCode(randomWithNextInt) ;
			userService.registerNewUser(user);
			return true;
		} else {
			System.out.println(isExist);

			return false;
		}
	}
	
	@PostMapping("/resetPassword/{user}/user")
	public boolean resetPassword(@PathVariable String user) {
		boolean isExist = userService.userNameCheck(user);
		if (!isExist) {
			return false;
		} else {
//			int min = 1000;  
//			int max = 9999;
			int randomWithNextInt = (int)(Math.random()*(max-min+1)+min); 
			//Random random = new Random();
		//	int randomWithNextInt = random.nextInt();
			User userData = userService.findById(user);
			String username =userData.getUserName();
			//userData.setCode(randomWithNextInt);
			//userService.ubdate(userData) ;
			userService.updateUserCode(randomWithNextInt, username);
			String text = " يرجي أستخدام هذا الرمز لاعادة كلمة المرور  "+randomWithNextInt ;
			sendEmail.sendSimpleMessage(user, "ااعادة تعيين كلمة المرور", text);
			return true;
		}
	}
	
	@PostMapping("/checkCode/{user},{code}")
	public boolean checkCode(@PathVariable String user ,@PathVariable long code) {
		boolean isExist = userService.userNameCheck(user);
		if (!isExist) {
			return false;
		} else {

			User userData = userService.findById(user);
			long codeDB = userData.getCode() ;
			if (code == codeDB) {
			return true ;
			}
			else {
			return false;
			}
		}
	}

	@PutMapping("/addUser/{id}")
	public String ubdateUser(@PathVariable String id, @RequestBody User user) {
		//System.out.println("getUserByUserName update " + id);
		User useer = new User();
		user = userService.findById(id);
		String useerPass = user.getUserPassword();
		user.setUserPassword(useerPass);
	//	System.out.println("password update " + useerPass);

		userService.ubdate(user);
		return "Services ubdate";
	}

	@PutMapping("/updateUserField/{username},{firstname},{lastname},{mobile}/user")
	public void updateUserField(@PathVariable String username, @PathVariable String firstname,
			@PathVariable String lastname, @PathVariable String mobile) {
		userService.updateUserField(username, firstname, lastname, mobile);
	}

	@PutMapping("/updatePassword/{username},{password}")
	public void updatePassword(@PathVariable String username, @PathVariable String password) {
		//System.out.print("kdhsfk");
		userService.updatePassword(username, password);
	}
	@PutMapping("/updatePasswordfromReset/{username},{password},{code}/user")
	public boolean updatePasswordfromReset(@PathVariable String username, @PathVariable String password,@PathVariable long code) {
		//System.out.print("kdhsfk");
		User userData = userService.findById(username);
		long codeDB = userData.getCode() ;
		if (code == codeDB) {
			userService.updatePassword(username, password);
			return true ;
		}
		else
		{
			return false ;
		}
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
