package com.ankith.dao;

import java.util.List;

import com.ankith.model.Address;
import com.ankith.model.User;

public interface AddressDao
{
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int id);
	public List<Address> getAddress(User user);

}
