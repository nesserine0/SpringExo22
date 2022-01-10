package com.example.demo;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		
		auth.jdbcAuthentication().dataSource(dataSource)
		    .passwordEncoder(new BCryptPasswordEncoder())
		    .usersByUsernameQuery("SELECT nom,mdp,true from compte where nom=?")
		    .authoritiesByUsernameQuery("SELECT c.nom, r.role FROM roles r, compte c WHERE c.nom = ? AND c.id = r.id_compte");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
	
		http.csrf().disable().authorizeRequests()
	
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/portail/**").hasRole("USER")
		.antMatchers("/").permitAll()
		.and().formLogin().permitAll()
		.and().logout().permitAll();
       
	}
	
	
	

}