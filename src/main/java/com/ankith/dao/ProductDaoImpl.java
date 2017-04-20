package com.ankith.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankith.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean addProduct(Product product) {
		System.out.println("getting");
		try{
		Session s=	sessionFactory.openSession();
			Transaction tx= s.beginTransaction();
			s.save(product);
			tx.commit();
			System.out.println("end");
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Product").getResultList();
	}

	@Override
	public Product get(int id) 
	{
	     
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public boolean update(Product product) {
		System.out.println("Product Price::::::::::::::::::::"+product.getProductPrice());
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(product);
			
			return true;
		}catch(Exception e){
			System.out.println("exception in ProductDAO:::::::::::::::"+e);
		return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean delete(int id)
	{
		System.out.println("testing");
		try{
		 Query q= sessionFactory.getCurrentSession().createQuery("DELETE Product WHERE productId = :ID");
		 q.setParameter("ID", id);
		 q.executeUpdate();
		 return true;
	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	
	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	@Override
	public List<Product> getCatProducts(Integer id) 
	{	// TODO Auto-generated method stub
		try{
			Query q=sessionFactory.getCurrentSession().createQuery("from Product where category_id=:id");
			q.setParameter("id", id);
			return q.getResultList();
			
		}
	catch(Exception e){
		return null;
	}
	}

}