package com.ankith.dao;

import java.util.List;

import com.ankith.model.Product;

public interface ProductDao
{
	
	 public boolean addProduct(Product product);
	 public List<Product> allProducts();
	 public Product get(int id);
	 public boolean update(Product product);
	 public boolean delete(int id);
	 List<Product> getCatProducts(Integer id);

}