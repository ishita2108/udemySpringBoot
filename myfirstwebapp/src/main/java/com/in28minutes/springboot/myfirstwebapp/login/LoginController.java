package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	// private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginJsp() {
		// logger.debug("Request param is {}", name);
		// logger.info("I want this printed at info level.Request param is {}", name);
		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap map) {
		map.put("name", name);
		if (authenticationService.authenticate(name, password)) {
			return "welcome";
		}
		map.put("errorMessage", "InvalidCredntials! Please Try Again.");
		return "login";

	}

}
