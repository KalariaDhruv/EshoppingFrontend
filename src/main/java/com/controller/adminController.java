package com.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;


@Controller

public class adminController {
	
	
	@Autowired
	SupplierDao supplierDao;
	
	
	@Autowired
	CategoryDao categoryDao;
	
	
	
	@RequestMapping("/adding")
	public String adding()
	{
		return "adding";
	}

	
	

	
	@RequestMapping(value="/saveSupp", method=RequestMethod.GET)
	@Transactional
	public ModelAndView saveSupp(@ModelAttribute("sid")int sid, @ModelAttribute("sname")String sname)
	{
		System.out.print("in Supplier");
		ModelAndView mv=new ModelAndView("adding");
		
		//mv.addObject("user",new User());
		//System.out.println(mv.getViewName());
		
		//mv.setViewName("register");
		System.out.print("after Suppiler");
		return mv;
		
	}	
	
	@RequestMapping(value="/saveSupp", method=RequestMethod.POST)
	@Transactional
	public ModelAndView save(@ModelAttribute("sid")int sid, @ModelAttribute("sname")String sname)
	{
		System.out.print("in post supplier");
		ModelAndView mv=new ModelAndView();
		Supplier ss=new Supplier();
		ss.setSid(sid);ss.setSupplierName(sname);
		supplierDao.insertSupplier(ss);
		mv.setViewName("adding");
		return mv;
		
	}
	
	
	
	@RequestMapping(value="/saveCat", method=RequestMethod.GET)
	@Transactional
	public ModelAndView saveCat(@ModelAttribute("cid")int cid, @ModelAttribute("cname")String cname)
	{
		System.out.print("in category");
		ModelAndView mv=new ModelAndView("adding");
		
		//mv.addObject("user",new User());
		//System.out.println(mv.getViewName());
		
		//mv.setViewName("register");
		System.out.print("after category");
		return mv;
		
	}	
	
	@RequestMapping(value="/saveCat", method=RequestMethod.POST)
	@Transactional
	public ModelAndView save1(@ModelAttribute("cid")int cid, @ModelAttribute("cname")String cname)
	{
		System.out.print("in post category");
		ModelAndView mv=new ModelAndView();
		Category cc=new Category();
		cc.setCid(cid);
		cc.setCname(cname);
		categoryDao.insertCategory(cc);
		mv.setViewName("adding");
		return mv;
		
	}
	
	
}