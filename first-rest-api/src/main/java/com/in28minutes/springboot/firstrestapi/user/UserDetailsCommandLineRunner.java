package com.in28minutes.springboot.firstrestapi.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {
	
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	private UserDetailsRepository repository;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void run(String... args) throws Exception {
		repository.save(new UserDetails("Ranga", "Admin"));
		repository.save(new UserDetails("Ravi", "Admin"));
		repository.save(new UserDetails("John", "Manager"));
		
		List<UserDetails> users = repository.findAll();
		users.forEach(user -> logger.info(user.toString()));
		
		List<UserDetails> usersByRole = repository.findByRole("Admin");
		usersByRole.forEach(user -> logger.info(user.toString()));

	}
}
