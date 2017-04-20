package com.ankith.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ankith.model.Address;
import com.ankith.model.User;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addAddress(Address address) {
		try {
			Session ses= sessionFactory.openSession();
			Transaction tx = ses.beginTransaction();
			ses.save(address);
			tx.commit();
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateAddress(Address address) {
		try {
		Session s=	sessionFactory.openSession();
	Transaction tx=	s.beginTransaction();
	s.update(address);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteAddress(int id) {
		try{
			
			Session s=sessionFactory.openSession();
		Transaction tx=	s.beginTransaction();
		Query q=	s.createQuery("DELETE Address where id=:ID");
			q.setParameter("ID", id);
			q.executeUpdate();
			tx.commit();
			
			return true;
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public List<Address> getAddress(User user) {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
	Query q=	s.createQuery("From Address where Users_id=:id");
		q.setParameter("id", user.getId());
		List<Address> li=	q.getResultList();
		tx.commit();
		return li;
	}

}
