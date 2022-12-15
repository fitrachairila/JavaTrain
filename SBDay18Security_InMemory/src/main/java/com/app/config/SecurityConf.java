package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configurable
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
	
	//method otentikasi
	@Autowired
	public void ConfAuth(AuthenticationManagerBuilder AuthB) throws Exception{
		//auth in memory
		//Configure User Authentication
		AuthB.inMemoryAuthentication()
		.withUser("fcakbar").password("{noop}xxx").roles("Staff")
		.and()
		.withUser("bukopin").password("{noop}22").roles("Admin");
	}
	
	//method otorisasi
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/default/list").hasRole("Staff")
		.antMatchers("/api/default/add").hasRole("Admin")
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
