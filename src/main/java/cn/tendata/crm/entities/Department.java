package cn.tendata.crm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 部门
 * @author Administrator
 *
 */
@Entity
public class Department {
	
	/*
	 * 部门编号
	 */
	@Id
	@GeneratedValue
     private int dpId;
     
	/*
	 * 部门名称
	 */
     private String dpName;
     
     
     /*
 	 * 部门员工人数
 	 */
     private int numOfEmployess;

	public int getDpId() {
		return dpId;
	}

	public void setDpId(int dpId) {
		this.dpId = dpId;
	}

	public String getDpName() {
		return dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public int getNumOfEmployess() {
		return numOfEmployess;
	}

	public void setNumOfEmployess(int numOfEmployess) {
		this.numOfEmployess = numOfEmployess;
	}
     
     
}
