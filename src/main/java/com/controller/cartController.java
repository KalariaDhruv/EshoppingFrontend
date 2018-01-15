package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

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

import com.Dao.CartDao;
import com.Dao.CategoryDao;
import com.Dao.OrdersDao;
import com.Dao.ProductDao;
import com.Dao.SupplierDao;
import com.Dao.UserDao;
import com.model.Cart;
import com.model.Category;
import com.model.Orders;
import com.model.Product;
import com.model.Supplier;
import com.model.User;

@Controller
//@RequestMapping("/cart")
public class cartController 
{
	@Autowired
	ProductDao productDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value="/productDetails/${p.pid }")
	public ModelAndView prodDet(@PathVariable("pid")int pid)
	{
		System.out.println("in cart prod details controller");
		ModelAndView mv =new ModelAndView();
		Product prod=productDao.findByPID(pid);
		mv.addObject("prod", prod);
		mv.setViewName("prodDetails");
		return mv;
	}
	
	@RequestMapping(value="/addToCart",method =RequestMethod.POST)
	public ModelAndView addtocart(HttpServletRequest request)
	{
		ModelAndView mv =new ModelAndView();
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		
		try{
			int pid=Integer.parseInt(request.getParameter("pid"));
			Double price=Double.parseDouble(request.getParameter("pPrice"));
			int qty=Integer.parseInt(request.getParameter("pQty"));
			String pname =request.getParameter("pname");
			String imageName =request.getParameter("imageName");
			Cart cartExists=cartDao.getCartById(pid,userEmail);
			
			if(cartExists==null)
			{
				Cart cm =new Cart();
				cm.setCartPrice(price);
				cm.setCartProductID(pid);
				cm.setCartStock(qty);
				cm.setCartImage(imageName);
				cm.setCartProductName(pname);
				
				User u=userDao.findUserByEmail(userEmail);
				cm.setCartUserDetails(u);
				cartDao.insertCart(cm);
			}
			else if(cartExists !=null)
			{
				Cart cm =new Cart();
				cm.setCartId(cartExists.getCartId());
				cm.setCartPrice(price);
				cm.setCartProductID(pid);
				cm.setCartStock(cartExists.getCartStock()+qty);
				cm.setCartImage(imageName);
				cm.setCartProductName(pname);
				
				User u=userDao.findUserByEmail(userEmail);
				cm.setCartUserDetails(u);
				cartDao.updateCart(cm);
			}
			mv.addObject("cartInfo", cartDao.findByCartID(userEmail));
			mv.setViewName("cart");
			return mv;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			mv.addObject("cartInfo",cartDao.findByCartID(userEmail));
			mv.setViewName("cart");
			return mv;
		}
	}

	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public ModelAndView checkoutProcess(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		Principal principal=req.getUserPrincipal();
		String userEmail=principal.getName();
		User u=userDao.findUserByEmail(userEmail);
		List<Cart> cart=cartDao.findByCartID(userEmail);
		mv.addObject("user",u);
		mv.addObject("cart",cart);
		return mv;
	}
	
	@RequestMapping(value="/Orderprocess", method=RequestMethod.POST)
	public ModelAndView orderProcess(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		Orders ord=new Orders();
		Principal principal=req.getUserPrincipal();
		String userEmail=principal.getName();
		Double total=Double.parseDouble(req.getParameter("total"));
		String payment=req.getParameter("payment");
		User u=userDao.findUserByEmail(userEmail);
		ord.setUser(u);
		ord.setTotal(total);
		ord.setPayment(payment);
		ordersDao.insertOrders(ord);
		mv.addObject("orderDetails",u);
		mv.setViewName("ack");
		return mv;
	}

	@RequestMapping(value="/deletePCart/{cartId}")
	public ModelAndView deleteCartItem(@PathVariable("cartId")int cartId , HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		Principal principal=req.getUserPrincipal();
		String userEmail=principal.getName();
		cartDao.deleteCart(cartId);
		mv.addObject("cartInfo",cartDao.findByCartID(userEmail));
		mv.setViewName("cart");
		return mv;
	}
}

