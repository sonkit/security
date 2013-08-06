package com.wonders.security.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wonders.security.entity.Role;
import com.wonders.security.entity.User;
import com.wonders.security.repository.RoleRepository;
import com.wonders.security.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Inject
	private UserRepository userRepository;
	
	@Inject
	private RoleRepository roleRepository;
	
	public User addRolesToUser(Long userId, Long... roleIds) {
		
		User user = userRepository.findOne(userId);
		
		List<Role> roles = (ArrayList<Role>) roleRepository.findAll(Arrays
				.asList(roleIds));
		
		user.getRoles().addAll(roles);
		
		return user;
	}
	
	public User removeRolesFromUser(Long userId, Long... roleIds) {
		
		User user = userRepository.findOne(userId);
		
		List<Role> roles = (ArrayList<Role>) roleRepository.findAll(Arrays
				.asList(roleIds));
		
		user.getRoles().removeAll(roles);
		
		return user;
	}

}
