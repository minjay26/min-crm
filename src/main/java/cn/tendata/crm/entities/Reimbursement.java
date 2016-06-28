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
 * 财务报销类
 * @author Administrator
 *
 */
@Entity
public class Reimbursement {
    
	/*
	 * 报销号id
	 */
	@Id
	@GeneratedValue
	private Integer rbId;
	
	/*
	 * 申请报销人
	 */
	 @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="sId",unique=false)
	private User applicant;
	 
	 /*
		 * 报销总金额
		 */
	 private double amount;
	 
	 /*
	  * 报销缘由
	  */
	 private String reason;
	 
	 /*
	  * 报销状态
	  */
	 private String status;
	 
	 /*
	  * 报销申请时间
	  */
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	   private Date creatTime;
	 
	 /*
	  * 报销审核人
	  */
	 @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="checkUser",unique=false)
	 private User checkUser;
	 
	 /*
	  * 报销通过时间
	  */
	 private Date checkTime;


	public Integer getRbId() {
		return rbId;
	}


	public void setRbId(Integer rbId) {
		this.rbId = rbId;
	}


	public User getApplicant() {
		return applicant;
	}


	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreatTime() {
		return creatTime;
	}


	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}


	public User getCheckUser() {
		return checkUser;
	}


	public void setCheckUser(User checkUser) {
		this.checkUser = checkUser;
	}


	public Date getCheckTime() {
		return checkTime;
	}


	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	 
	 
}
