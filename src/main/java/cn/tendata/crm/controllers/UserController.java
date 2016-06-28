package cn.tendata.crm.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;
import cn.tendata.crm.controllers.util.GetCurrentInfo;
import cn.tendata.crm.entities.SysRole;
import cn.tendata.crm.entities.User;
import cn.tendata.crm.service.SysRoleService;
import cn.tendata.crm.service.UserService;

/**
 * 用户控制类
 * @author Administrator
 *
 */
@Controller
public class UserController {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService useService;
	
	/**
	 * 自动注入用户角色service
	 */
	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 自动注入当前登录用户信息组件
	 */
	@Autowired
    private GetCurrentInfo currentInfo;
   
	@RequestMapping("/department_users/{page}/{dpId}")
	public String getUsersByDpId(@PathVariable int page,@PathVariable int dpId,ModelMap map){
		Page<User> usersPage=this.useService.getDepartment_users(dpId,page,5);
		List<User> usersOfSameDpId=usersPage.getContent();
		int pageSum=usersPage.getTotalPages();
		/**
		 * 根据部门id查询出当前部门的人数
		 * 如果人数小于0，为false；大于0，则为true
		 * 前端界面根据isExist的值判断当前部门是否有员工，有则显示所有员工信息，无则提示无法查询到当前部门员工信息
		 */
		if (usersOfSameDpId.size()>0) {
			map.addAttribute("isExist", true);
		}else {
			map.addAttribute("isExist", false);
		}
		map.addAttribute("currentDpId", dpId);
		map.addAttribute("pageSum", pageSum);
		map.addAttribute("usersOfSameDpId", usersOfSameDpId);
		return "/user/users";		
	}

	@RequestMapping(value="/user-add/{dpId}",method=RequestMethod.GET)
	public String addUser(@PathVariable int dpId,ModelMap map){
		map.addAttribute("currentDpId", dpId);
		return "/user/add";
	}
	
	/**
	 * 根据当前部门id，为该部门增加员工信息
	 * @param dpId
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/user-add",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(User user,Integer roleId){	
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
		LOGGER.warn("{}增加了用户{}",currentUser.getUsername(),user.getUsername());
		/**
		 * roleId为客户端传过来的角色id，根据该id获取对应角色实体，从而使user对象set role属性
		 */
		SysRole role=this.sysRoleService.get(roleId);
		user.setRole(role);	
		this.useService.add(user);
		this.useService.addUserNumOfDp(user.getDpId());
		return "{ result: true, message: \"保存成功\" }";
	}
	
	/**
	 * 修改员工信息
	 * @param sId
	 * @param map
	 * @return
	 */
	@RequestMapping(value="user-modify/{sId}",method=RequestMethod.GET)
	public String modify(@PathVariable int sId,ModelMap map){
		User user=this.useService.get(sId);
		map.addAttribute("user", user);
		return "/user/modify";
	}
	
	@RequestMapping(value="user-modify",method=RequestMethod.POST)
	@ResponseBody
	public String modify(User user){
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
		LOGGER.warn("{}修改了用户{}的信息",currentUser.getUsername(),user.getUsername());
		this.useService.updata(user);
		return "{ result: true, message: \"修改成功\" }";
	}
}
