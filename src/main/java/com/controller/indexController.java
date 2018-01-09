package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.UserDao;
import com.model.User;

@Controller
public class indexController {

	@Autowired
	UserDao userDao;
	
	
	@RequestMapping(value = "/")
	public String index() {

		//model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";

	}
	
	/*@RequestMapping(value = "/index")
	public String home() 
	{
			return "index";
	}*/

	@RequestMapping(value="/saveRegister", method=RequestMethod.GET)
	public ModelAndView saveRegister(@ModelAttribute("user")User user)
	{
		System.out.println("in register");
		ModelAndView mv=new ModelAndView("register");
		
		//mv.addObject("user",new User());
		//System.out.println(mv.getViewName());
		
		//mv.setViewName("register");
		System.out.println("after register");
		return mv;
		
	}	
	@RequestMapping(value="/saveRegister", method=RequestMethod.POST)
	public ModelAndView save(User user)
	{
		System.out.println("in  post register");
		userDao.insertUser(user);
		ModelAndView mv=new ModelAndView("index","user",new User());
		
		//mv.addObject("user",new User());
		//System.out.println(mv.getViewName());
		
		//mv.setViewName("register");
		System.out.println("after post register");
		return mv;
		
	}	
	
	@RequestMapping("/goToLogin")
	public String gotologin()
	{
		return "login";
	}
	
	@RequestMapping("/userLogged")
	public String underlogged()
	{
		return "redirect:/login";
	}
	
	@RequestMapping("/error")
	public String underError()
	{
		return "error";
	}
	
	@RequestMapping("/reLogin")
	public String relogin()
	{
		return "redirect:/goToLogin";
	}
}