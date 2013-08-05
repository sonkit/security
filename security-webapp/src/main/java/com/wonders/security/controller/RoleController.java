package com.wonders.security.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wonders.security.core.controller.AbstractCrudController;
import com.wonders.security.core.repository.MyRepository;
import com.wonders.security.entity.Role;
import com.wonders.security.repository.RoleRepository;

@Controller
@RequestMapping("roles")
public class RoleController extends AbstractCrudController<Role, Long> {

	@Inject
	private RoleRepository roleRepository;

	@Override
	protected MyRepository<Role, Long> getRepository() {
		return roleRepository;
	}
	
	@RequestMapping(value = "findByUserId", method = RequestMethod.GET)
	protected @ResponseBody List<Role> findByUserId(long userId) {
		return roleRepository.findByUserId(userId);
	}

}
