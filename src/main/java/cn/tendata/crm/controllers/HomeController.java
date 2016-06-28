package cn.tendata.crm.controllers;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;
import cn.tendata.crm.controllers.util.GetCurrentInfo;

@Controller
public class HomeController {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private GetCurrentInfo currentInfo;
	
	/**
	 * 主页的访问路径
	 * @return
	 */
	@RequestMapping("/home")
   public String home(){
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
	       LOGGER.warn("{}登录了",currentUser.getUsername());
	      return "/home";
   }
}
