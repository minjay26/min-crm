package cn.tendata.crm.controllers;

import java.util.List;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;
import cn.tendata.crm.controllers.util.GetCurrentInfo;
import cn.tendata.crm.entities.Department;
import cn.tendata.crm.service.DepartmentService;
/**
 * 部门控制类
 * @author Administrator
 *
 */
@Controller
public class DepartmentController {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private DepartmentService departmentService;
    
	/**
	 * 自动注入当前登录用户信息组件
	 */
	@Autowired
    private GetCurrentInfo currentInfo;
	
	@RequestMapping("/department_getAll")
	public String getAllDepartment(ModelMap map){
		List<Department> dpList=this.departmentService.getAll();
		map.addAttribute("dpList", dpList);
		return "/department/allDepartment";
	}
	
	
	@RequestMapping(value="/department-modify/{dpId}",method=RequestMethod.GET)
	public String modify(@PathVariable int dpId,ModelMap map){
		Department department=this.departmentService.get(dpId);
		map.addAttribute("currentDepartment", department);		
		return "/department/modify";		
	}
	
	
	@RequestMapping("/department-modify")
	@ResponseBody
	public String modify(Department department){
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
	LOGGER.warn("{}修改了部门：{}的信息",currentUser.getUsername(),department.getDpName());
		this.departmentService.modify(department);
		return "{result:true,message:\"修改成功\"}";
	}
	
	
	@RequestMapping("/department-remove/{dpId}")
	@ResponseBody
	public String remove(@PathVariable int dpId){
		Department department=this.departmentService.get(dpId);
		this.departmentService.remove(dpId);
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
		LOGGER.warn("{}删除了部门：{}",currentUser.getUsername(),department.getDpName());
		return "{result:true,message:\"删除成功\"}";
	}
	
	
	@RequestMapping(value="/department-add",method=RequestMethod.GET)
	public String add(){		
		return "/department/add";
	}
	
	@RequestMapping(value="/department-add",method=RequestMethod.POST)
	public String add(Department department){
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
		LOGGER.warn("{}增加了部门{}",currentUser.getUsername(),department.getDpName());
		this.departmentService.add(department);
		return "/department/add";
	}
}
