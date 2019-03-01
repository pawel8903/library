package pl.pawel.library.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.pawel.library.entity.User;
import pl.pawel.library.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/registerForm")
	public String registerForm(Model theModel) {
		User theUser = new User();
		theModel.addAttribute("userForm", theUser);
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User theUser,@RequestParam("configPassword")String configPassword, Model theModel) {
		System.out.println(theUser);
		if (userServiceImpl.checkAvaibleOfUsername(theUser.getUsername()) == false) {
			return registerFormError("Username already use.", theUser, theModel);
		}
		if (userServiceImpl.checkAvaibleOfEmail(theUser.getEmail()) == false) {
			return registerFormError("Email already use.", theUser, theModel);
		}
		if (userServiceImpl.checkMinimumSizeOfPassword(theUser.getPassword())) {
			return registerFormError("Password is to short. Need be at least 6 charakter.", theUser, theModel);
		}
		if (userServiceImpl.checkMaxSizeOfPassword(theUser.getPassword())) {
			return registerFormError("Password is to long. Need be maximum 12 charakter.", theUser, theModel);
		}
		if(userServiceImpl.checkConfigPassword(theUser.getPassword(),configPassword )) {
			return registerFormError("You entered various passwords.", theUser, theModel);
		}
		userServiceImpl.saveUser(theUser);
		return "login";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "login";
	} 

	@RequestMapping("/userLogin")
	public String userLogin(@RequestParam Map<String, String> requestParam,Model theModel) {
			if(userServiceImpl.checkCorrectOfLogin(requestParam.get("login"))) {
				return loginFormError("Login not found.", theModel);
			}else {
				if(userServiceImpl.checkCorrectOfPassword(requestParam.get("password"))) {
					return loginFormError("Wrong password",theModel);
				}
			}
			
		return "redirect:/book/booksList";
	}
	@RequestMapping("/usersList")
	public String usersList(Model theModel) {
		List<User> usersList = userServiceImpl.getUsers();
		theModel.addAttribute("users", usersList);
		return "userList";
	}
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userId) {
		userServiceImpl.deleteUser(userId);
		return "redirect:/user/usersList";
	}
	public String registerFormError(String message,User theUser,Model theModel) {
		theModel.addAttribute("userForm", theUser);
		theModel.addAttribute("error",message);
		return "register";
	}
	public String loginFormError(String message,Model theModel) {
		theModel.addAttribute("error",message);
		return "login";
	}
}
