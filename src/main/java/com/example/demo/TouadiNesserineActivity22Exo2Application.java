package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@SpringBootApplication
public class TouadiNesserineActivity22Exo2Application {

	public static void main(String[] args) {
		SpringApplication.run(TouadiNesserineActivity22Exo2Application.class, args);
	}
	
	
	@GetMapping("/admin")
	public String index() { return ("<h1> Console d’administration </h1>"); }
	
	
	@GetMapping("/portail")
	public String index2(){ return ("<h1> Portail utilisateur </h1>"); }
	
	@GetMapping("/")
	public String home(){ return "<h1> Welcome Home </h1>"; }
	
	/*@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView Login() {
		   
		   ModelAndView modelAndView=new ModelAndView();
		   modelAndView.setViewName("login");
           return modelAndView; 
		
	}*/
	


}
