package com.wonders.security.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wonders.security.core.controller.AbstractCrudController;
import com.wonders.security.core.repository.MyRepository;
import com.wonders.security.entity.User;
import com.wonders.security.repository.UserRepository;

@Controller
@RequestMapping("users")
public class UserController extends AbstractCrudController<User, Long> {
	
	@Inject
	private UserRepository userRepository;

	@Override
	protected MyRepository<User, Long> getRepository() {
		return userRepository;
	}

}
