package pl.pawel.library.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/*")
	public String mainPage() {
		return "redirect:/user/loginForm";
	}
}
