package cn.tendata.crm.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 客戶
 * @author Administrator
 *
 */
@Entity
public class Customer {
	/*
	 * 客戶编号
	 */
	@Id
	@GeneratedValue
   private int csId;
   
   /*
	 * 客戶姓名
	 */
   private String customerName;
   
   /*
	 * 客戶性别
	 */
   private String gender;
   
   /*
	 * 客戶公司
	 */
   private String company;
   
   /*
	 * 客戶类型
	 */
   private String type;
   
   /*
	 * 客戶地址
	 */
   private String address;
   
   /*
	 * 客戶电话
	 */
   private String phone;
   
   /*
	 * 负责客户的销售人员编号
	 */
  
   private int sId;
   
   /*
	 * 客戶加入时间
	 */
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date joinTime;

   
public int getCsId() {
	return csId;
}

public void setCsId(int csId) {
	this.csId = csId;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public int getsId() {
	return sId;
}

public void setsId(int sId) {
	this.sId = sId;
}

public Date getJoinTime() {
	return joinTime;
}

public void setJoinTime(Date joinTime) {
	this.joinTime = joinTime;
}
   
   
}
