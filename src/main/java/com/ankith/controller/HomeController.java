package com.ankith.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ankith.dao.CartDao;
import com.ankith.dao.CartItemDao;
import com.ankith.dao.CategoryDao;
import com.ankith.dao.ProductDao;
import com.ankith.dao.UserDao;
import com.ankith.model.Cart;
import com.ankith.model.CartItem;
import com.ankith.model.Product;
import com.ankith.model.User;

@Controller
public class HomeController 
{
	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartItemDao cartitemDao;
	
	@Autowired
	CartDao cartDao;
	@Autowired
	HttpSession session;
	
	@RequestMapping({"/","/home"})
	public String home(Principal principal,ModelMap model)
	{
		System.out.println("Hello entereed");
		User userobj=null;
	System.out.println("enterreed into home");
	if(principal!=null)
	{
		
		userobj=userDao.getUserByEmail(principal.getName());
		if(userobj.getRole().equals("ROLE_ADMIN"))
		{
			return "redirect:/adminpage";
		}
		else
		{
			System.out.println("entereed");
			System.out.println(categoryDao.allCategories());
			System.out.println(userobj);
			System.out.println(userobj.getCart());
			System.out.println(userobj.getCart().getId());
			System.out.println(userobj.getCart().getQuantity());
			session.setAttribute("cartcount",userobj.getCart().getQuantity());
			model.addAttribute("catlist",categoryDao.allCategories());
			
			return "index";
		}
		
	}
	else
	{
		model.addAttribute("catlist",categoryDao.allCategories());
		return "index";
	}	
	}
	@RequestMapping("/adminpage")
	public ModelAndView AdminPage()
	{
		return new ModelAndView("AdminHome");
	}
	@GetMapping("/login")
	public String Login(@RequestParam(value="error",required=false)String error,ModelMap model)
	{
		System.out.println(error);
		if(error!=null)
		{
			model.addAttribute("error","Authentication Failed");
			return "loginform";
		}
		model.addAttribute("title","Login");
		model.addAttribute("loginform",true);
		return "loginform";
	}

	@RequestMapping("cat/{id}/products")
	public String getProducts(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("id",id);
		model.addAttribute("products", productDao.allProducts());
		return "Products";
	}
	
	@RequestMapping("/{id}/catproducts")
	public @ResponseBody List<Product> allProducts(@PathVariable Integer id)
	{
		
		return productDao.getCatProducts(id);
	}
	
	@RequestMapping("/{id}/viewproduct")
	public String viewProduct(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("product",productDao.get(id));
		
		
		return "CustViewProduct";
	}
	
	
	@RequestMapping("customer/{id}/addcart")
	public String addCart(@PathVariable Integer id,Principal principal)
	{
		Integer catid=0;
		if(principal!=null)
		{
		 User user=userDao.getUserByEmail(principal.getName());
		Cart cart= user.getCart();
		CartItem cartItem =cartitemDao.getExistingCartItemCount(id, cart.getId());
		System.out.println("cartItem item object"+cartItem);
		Product product=productDao.get(id);
		catid=product.getCategory().getId();
		if(cartItem==null)
		{
		  cartItem=new CartItem();
		  cartItem.setQuantity(1);
		  cartItem.setProduct(product);
		  cartItem.setGrandTotal(product.getProductPrice());
		  cartItem.setCart(cart);
		  cartitemDao.addCartItem(cartItem);
		  cart.setGrandTotal(cart.getGrandTotal()+product.getProductPrice());
		  cart.setQuantity(cart.getQuantity()+1);
		  cartDao.updateCart(cart);
		}else
		{
			cartItem.setQuantity(cartItem.getQuantity()+1);
			cartItem.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
			cart.setGrandTotal(cart.getGrandTotal()+product.getProductPrice());
			  cart.setQuantity(cart.getQuantity()+1);
			  
			  
			  cartDao.updateCart(cart);
			  cartitemDao.updateCartItem(cartItem);
		}
		
		session.setAttribute("cartcount",cart.getQuantity());
		}
		
		return "redirect:/cat/"+catid+"/products";
	}
	
	


	}