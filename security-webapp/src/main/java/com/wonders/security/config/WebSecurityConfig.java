package com.wonders.security.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.wonders.security.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Inject
	private UserService userService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/login.html")
			.antMatchers("/app/**")
			.antMatchers("/images/**")
			.antMatchers("/**/*.js")
			.antMatchers("/**/*.css")
			.antMatchers("/*Service");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
         	.anyRequest().authenticated()
         	.and()
         .formLogin()
         	.loginPage("/login.html")
         	.loginProcessingUrl("/login")
         	.defaultSuccessUrl("/app.html", true)
         	.failureUrl("/login.html?error=1")
         	.and()
         .logout()
         	.and()
         .csrf()
         	.disable();
	}

	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(new Md5PasswordEncoder());
		authProvider.setUserDetailsService(userService);

		auth.authenticationProvider(authProvider);
	}

}
