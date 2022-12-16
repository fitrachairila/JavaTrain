package com.app.config;

import javax.sql.DataSource;

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
	
	@Autowired
	private DataSource ds;
	//method otentikasi melalui database
	@Autowired
	public void ConfAuth(AuthenticationManagerBuilder AuthB) throws Exception{
		AuthB.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery("select username,concat('{noop}',password), enabled from muser where username=?")
		.authoritiesByUsernameQuery("select username,role from muser where username = ?");
		
	}
	//method otorisasi
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/default/upload").hasAnyRole("Staff","Admin")
		.antMatchers("/api/default/Delete/{filename}").hasAnyRole("Admin")
		.antMatchers("/api/default/list").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
