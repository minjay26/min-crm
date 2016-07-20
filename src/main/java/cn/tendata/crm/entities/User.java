package cn.tendata.crm.entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户类
 * @author Administrator
 *
 */
@Entity
public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	/*
	 * 用户id
	 */
	@Id
	@GeneratedValue
     private int sId;
	
	/*
	 * 用户账户号
	 */
	private String account;
     
	/*
	 * 用户姓名
	 */
     private String username;
     
     /*
 	 * 用户性别
 	 */
     private String gender;
     
     /*
 	 * 用户密码
 	 */
     private String password;
     
     /*
 	 * 用户部门id
 	 */
     private int dpId;
     
     /*
 	 * 用户角色
 	 * 与用户角色表中的id是一对一关系
 	 */
     @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="Id",unique=false)
     private SysRole role;
     
     /**
      * 重写getAuthorities方法，将用户的角色作为权限
      */
 	@Override
 	public Collection<? extends GrantedAuthority> getAuthorities() {
 		List<GrantedAuthority> authorities=new ArrayList<>();
 		SysRole role=this.getRole();
 		authorities.add(new SimpleGrantedAuthority(role.getName()));
 		return authorities;
 		
 	}
    public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDpId() {
		return dpId;
	}

	public void setDpId(int dpId) {
		this.dpId = dpId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
	
	
	
     
     
}
