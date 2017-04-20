package com.ankith.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankith.model.User;


@Transactional
@Repository("userdao")
public class UserDaoImpl implements UserDao
{
	
SessionFactory sessionFactory;

	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}



	public boolean addUsers(User user) {
		try {
			System.out.println("entered in add user dao");

			sessionFactory.getCurrentSession().persist(user);

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public User getUser(int id) {

		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(id));
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("user details in userdaoimp:::::::::" + user);
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	public User getUserNameByUserName(String name) {
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email=:email");
		query.setParameter("email", name);
		User User = (User) query.getSingleResult();
		return User;
	}

	@SuppressWarnings("deprecation")
	public User getUserByEmail(String email) {
		@SuppressWarnings("rawtypes")
		Query q = sessionFactory.getCurrentSession().createQuery("From User where email=:email", User.class);
		q.setParameter("email", email);
		try {
			Object o = q.getSingleResult();
			return (User) o;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	
}
