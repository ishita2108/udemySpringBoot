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
public class WelcomeController {

	@Autowired
	private AuthenticationService authenticationService;
	
	public WelcomeController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	// private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage( ModelMap map) {
		// logger.debug("Request param is {}", name);
		// logger.info("I want this printed at info level.Request param is {}", name);
		map.put("name","ishita");
		return "welcome";

	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap map) {
//		map.put("name", name);
//		if (authenticationService.authenticate(name, password)) {
//			return "welcome";
//		}
//		map.put("errorMessage", "InvalidCredntials! Please Try Again.");
//		return "login";
//
//	}

}
