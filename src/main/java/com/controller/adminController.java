package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;


@Controller
@RequestMapping("/admin")
public class adminController {
	
	@Autowired
	ProductDao productDao;
	
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
	
	
	/*========new added==========*/
	
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public String saveProd(HttpServletRequest request,@RequestParam("file")MultipartFile file) 
	{
				
		Product prod=new Product();
		String pname=request.getParameter("pName");	
		System.out.println(pname);
		prod.setPname(request.getParameter("pName"));
		String desc=request.getParameter("pDescription");
		System.out.println(desc);
		prod.setDescription(request.getParameter("pDescription"));
		
		
		int x=Integer.parseInt(request.getParameter("pPrice"));
		System.out.println(x);
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		int x1=Integer.parseInt(request.getParameter("pstock"));
		System.out.println(x1);
		prod.setStock(Integer.parseInt(request.getParameter("pstock")));
		
		prod.setCategory(categoryDao.findByCatId(Integer.parseInt(request.getParameter("pCategory"))));
		prod.setSupplier(supplierDao.findBySuppId(Integer.parseInt(request.getParameter("pSupplier"))));
		System.out.println(prod);
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImageName(filename);
		productDao.insertProduct(prod);
	
		System.out.println("File path"+filepath);
		
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources"+filename));
			
			fos.write(imagebyte);
			fos.close();
			
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return "adding"; 
	}
	
	
	@ModelAttribute
	public void loadingDataInPage(Model m)
	{
		m.addAttribute("satList",supplierDao.retrieve());
		m.addAttribute("catList",categoryDao.retrieve());
		m.addAttribute("prodList",productDao.retrieve());
	}
	
	@RequestMapping("/productList")
	public ModelAndView prodList()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("prodList",productDao.retrieve());
		mv.setViewName("ProductAdminList");
		return mv;
	}
	
	@RequestMapping("/supplierList")
	public ModelAndView suppList()	
	{
		ModelAndView mv=new ModelAndView();
		System.out.println("in controller");
		mv.addObject("satList",supplierDao.retrieve());
		mv.setViewName("suppAdminList");
		return mv;
	}
	
	@RequestMapping("/categoryList")
	public ModelAndView catList()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("catList",categoryDao.retrieve());
		mv.setViewName("CategoryAdminList");
		return mv;
	}
	
	@RequestMapping("/deleteProd/ (pid)")
	public String deleteProduct(@PathVariable("pid")int pid)
	{
		productDao.deleteProd(pid);
		return "redirect:/productList?del";
	}
	
	@RequestMapping("/updateProd")
	public ModelAndView updateproduct(@RequestParam("pid") int pid)
	{
		ModelAndView mv=new ModelAndView();
		Product p=productDao.findByPID(pid);
		mv.addObject("prod",p);
		mv.addObject("catList", categoryDao.retrieve());
		mv.addObject("satList", supplierDao.retrieve());
		mv.setViewName("updateProduct");
		return mv;
	}
	
	@RequestMapping(value="/ProductUpdate",method=RequestMethod.POST)
	public String updateProd(HttpServletRequest request,@RequestParam("file")MultipartFile file) 
	{
		
		String pid =request.getParameter("pid");
		
		Product prod=new Product();
		prod.setPid(Integer.parseInt(pid));
		
		prod.setPname(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pstock")));
		
		String cat=request.getParameter("pCategory");
		String sat=request.getParameter("pSupplier");
		
		
		prod.setCategory(categoryDao.findByCatId(Integer.parseInt(cat)));
		prod.setSupplier(supplierDao.findBySuppId(Integer.parseInt(sat)));
		
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImageName(filename);
		productDao.update(prod);
	
		System.out.println("File path"+filepath);
		
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources"+filename));
			
			fos.write(imagebyte);
			fos.close();
			
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return "redirect:/productList?update";
	}

	
	
}