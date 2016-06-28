package cn.tendata.crm.controllers.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class GetCurrentInfo {
	
	/**
	 * 从springsecurity当前上下文中获取当前登录用户信息
	 * @return
	 */
      public  UserDetails getCurrentInfo(){
    	  UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
    			    .getAuthentication()
    			    .getPrincipal();
    			return userDetails;
      }
}
