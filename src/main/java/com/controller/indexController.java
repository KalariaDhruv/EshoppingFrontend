package com.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.UserDao;
import com.model.Category;
import com.model.User;

@Controller

public class indexController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;

	
	
	@RequestMapping(value = "/")
	public String index() {

		//model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";

	}
	
	@RequestMapping(value = "/index")
	public String home() 
	{
			return "index";
	}
	
	@RequestMapping(value="/saveRegister", method=RequestMethod.GET)
	public ModelAndView saveRegister()
	{
		System.out.println("in register");
		ModelAndView mv=new ModelAndView();
		
		//mv.addObject("user",new User());
		//System.out.println(mv.getViewName());
		
		//mv.setViewName("register");
		mv.addObject("user",new User());
		mv.setViewName("register");
		System.out.println("after register");
		return mv;
		
	}
	@RequestMapping(value="/saveRegister", method=RequestMethod.POST)
	public ModelAndView saveRegister(@ModelAttribute("user")User user)
	{
		System.out.println("in register");
		ModelAndView mv=new ModelAndView();
		user.setRole("ROLE_USER");
		
		mv.addObject("user",new User());
		userDao.insertUser(user);
		//System.out.println(mv.getViewName());
		
		mv.setViewName("index");
		System.out.println("after register");
		return mv;
		
	}
	
	
	
/*
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
*/	
	/*@RequestMapping(value="/saveProduct", method=RequestMethod.GET)
	@Transactional
	public ModelAndView saveProd(@ModelAttribute("pid")int pid, @ModelAttribute("pname")String pname)
	{
		System.out.print("in product");
		ModelAndView mv=new ModelAndView("adding");
		
		//mv.addObject("user",new User());
		//System.out.println(mv.getViewName());
		
		//mv.setViewName("register");
		System.out.print("after product");
		return mv;
		
	}	
	
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveProd1(@ModelAttribute("pid")int pid, @ModelAttribute("pname")String pname)
	{
		System.out.print("in post product");
		ModelAndView mv=new ModelAndView();
		Category cc=new Category();
		cc.setPid(pid);
		cc.setPname(pname);
		productDao.insertProduct(cc);
		mv.setViewName("adding");
		return mv;
		
	}*/
	
	@RequestMapping("/productCustList")
	public ModelAndView getCustTable(@RequestParam("cid")int cid)
	{
		System.out.println("in Category choice controller");
		ModelAndView mv=new ModelAndView();
		mv.addObject("prodList", productDao.retrieve());
		mv.setViewName("productCustList");
		System .out.println("after Category choice controller");
		return mv;
		
	}
	/*
	@RequestMapping("/productCustListd")
	public ModelAndView getCustTabled(@RequestParam("cid")int cid)
	{
		System.out.println("in Category choice controller");
		ModelAndView mv=new ModelAndView();
		mv.addObject("prodList", productDao.retrieve());
		mv.setViewName("productCustList");
		System .out.println("after Category choice controller");
		return mv;
		
	}*/
	
	
	@ModelAttribute
	public void getData(Model m)
	{
		m.addAttribute("catList", categoryDao.retrieve());
	}
	
	@RequestMapping("/goToLogin")
	public String gotologin()
	{
		return "login";
	}
	
	@RequestMapping("/userlogged")
	public String underlogged()
	{
		return "redirect:/index";
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
	
	@RequestMapping("/logout")
	   public String logout(Model model)
	   {
		   model.addAttribute("msg", "successfully Logout");
		   return "login";
		   
	   }
}