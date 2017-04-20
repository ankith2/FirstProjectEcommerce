package com.ankith.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankith.model.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
	Session s=	sessionFactory.openSession();
	Transaction tx=s.beginTransaction();
	s.save(cart);
	tx.commit();
		return false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		
		try{
		System.out.println("cart id in update cart :::::::::::"+cart.getId());
		sessionFactory.getCurrentSession().update(cart);
		return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean resetCart(int id) {
		// TODO Auto-generated method stub
		System.out.println("cart id"+id);
	Query q=	sessionFactory.getCurrentSession().createQuery("update Cart set grandTotal=:total, quantity=:quan where id=:id ");
	q.setParameter("total", 0.0f);
	q.setParameter("quan", 0);
	q.setParameter("id", id);
 int i=	q.executeUpdate();
 System.out.println("updated cart i value:::::::::::::::::"+i);
		return false;
	}

	@Override
	public Cart getCart(Integer id) {
		try {
			return sessionFactory.getCurrentSession().createQuery("From Cart where id=:id", Cart.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	


}
