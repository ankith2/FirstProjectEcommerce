package com.ankith.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ankith.config.ApplicationContextConfig;
import com.ankith.dao.AddressDao;
import com.ankith.dao.CartDao;
import com.ankith.dao.CartItemDao;
import com.ankith.dao.CategoryDao;
import com.ankith.dao.ProductDao;
import com.ankith.dao.UserDao;
import com.ankith.model.Address;
import com.ankith.model.Cart;
import com.ankith.model.CartItem;
import com.ankith.model.Category;
import com.ankith.model.Product;
import com.ankith.model.User;


public class TestCase 
{
public static void main(String[] args)
{
	@SuppressWarnings("unused")
	AbstractApplicationContext context=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
	
	/*UserDao userdao =(UserDao) context.getBean("userdao");
	User user= new User();
	
	user.setUserName("SaiBaba");
	user.setPassword("password@123");
	user.setEmail("rama@gmail.com");
	user.setRole("ROLE_ADMIN");
	user.setIs_Active(true);
	user.setMobile("7890909045");
	userdao.addUsers(user);	

	*/
	

	/*CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
	
	Category category = new Category();
	category.setCategoryName("MensWear");
	categoryDAO.newCategory(category);
	
	*/
	
	CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
	ProductDao productDAO= (ProductDao) context.getBean("productDAO");
	Product product = new Product();
	product.setProductName("mens sports wear");
	product.setProductPrice(3000);
	product.setQuantity(2);
	product.setStatus(true);
	product.setProductDespription("sports are comfortable to play");
	product.setCategory(categoryDAO.getCategory(1));
	productDAO.addProduct(product);
	
	
	
	/*AddressDao addressdao =(AddressDao) context.getBean("addressDao");
	 UserDao userDAO= (UserDao) context.getBean("userdao");
		Address address= new Address();
		
		address.setHouseNo("304");
		address.setStreet("fateh sultan lane");
		address.setCity("hyd");
		address.setState("Telangana");
		address.setCountry("india");
		address.setPin("500050");
		address.setUsers(userDAO.getUser(1));
		addressdao.addAddress(address);
		*/
	/*CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
	CartDao cartDao=(CartDao)context.getBean("cartDao");
	
	UserDao userdao =(UserDao) context.getBean("userdao");
	ProductDao productDAO= (ProductDao) context.getBean("productDAO");
	Cart cart=new Cart();
	cart.setId(1);
	cart.setUsers(userdao.getUser(1));
	CartItem cartItem=new CartItem();
	cartItem.setCart(cart);
	cartItem.setQuantity(2);
	Product product=productDAO.get(1);
	cartItem.setProduct(product);
	cartItem.setGrandTotal(cartItem.getQuantity()*product.getProductPrice());
	List<CartItem> cartItems=new ArrayList<>();
	cartItems.add(cartItem);
	cart.setCartItems(cartItems);
	cart.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
	cart.setQuantity(cart.getQuantity()+cartItem.getQuantity());
	cartDao.addCart(cart);
	*/
	
}
}
