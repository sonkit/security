package com.wonders.security.controller;

import java.security.MessageDigest;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@Override
	protected @ResponseBody User add(@RequestBody User user) {
		user.setPassword(md5(user.getPassword()));
		return super.add(user);
	}

	@Override
	protected @ResponseBody User modify(@RequestBody User user) {
		user.setPassword(md5(user.getPassword()));
		return super.modify(user);
	}

	private String md5(String source) {
		StringBuffer sb = new StringBuffer(32);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(source.getBytes("utf-8"));

			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

}
