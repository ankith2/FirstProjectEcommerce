package com.ankith.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


	@Table
	@Entity
	public class User implements 	Serializable
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Size(min=6,message="minimun of 6 characters")
		private String userName;
		@Size(min=6,message="minimun of 6 characters")
		private String password;
		@Column(unique=true)
		private String email;
		@Column(unique=true)
		@Size(min=10,max=10,message="minimun of 6 characters")
		private String mobile;
		private String role;
		private boolean is_Active;
		@OneToMany(cascade=CascadeType.ALL,mappedBy="users")
		private List<Address> address=new ArrayList<>();
		@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="users")
		private Cart cart;
				
				
		public List<Address> getAddress() {
			return address;
		}
		public void setAddress(List<Address> address) {
			this.address = address;
		}
		public Cart getCart() {
			return cart;
		}
		public void setCart(Cart cart) {
			this.cart = cart;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isIs_Active() {
			return is_Active;
		}
		public void setIs_Active(boolean is_Active) {
			this.is_Active = is_Active;
		}
		
		
		
	}

