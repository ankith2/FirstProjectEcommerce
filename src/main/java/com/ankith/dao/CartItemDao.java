package com.ankith.dao;

import java.util.List;
import java.util.Map;

import com.ankith.model.CartItem;

public interface CartItemDao {
	public boolean addCartItem(CartItem cartItem);
	public List<CartItem> getAll(int id);
    public boolean deleteCartItem(CartItem cartItem);
    public CartItem getCartItem(int id);
    public boolean deleteAll(int cart_id);
    public CartItem getExistingCartItemCount(int productId,int cart_id);
    public boolean updateCartItem(CartItem cartItem);
    

}