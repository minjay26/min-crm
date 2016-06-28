package cn.tendata.crm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 用戶角色实体类
 * @author Administrator
 *
 */
@Entity
public class SysRole {
	
	/**
	 * 角色id
	 */
	@Id
	@GeneratedValue
     private int Id;
     
	/**
	 * 角色描述
	 */
     private String  name;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
     
     
}
