package cn.tendata.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tendata.crm.response.Log;
import cn.tendata.crm.service.LogService;
/**
 * 日志信息控制类
 * @author Administrator
 *
 */
@Controller
public class LogController {
	
	@Autowired
	private LogService logservice;
    
	/**
	 * 以分页形式获取数据库中的日志记录
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping("log_getAll/{page}")
	public String getAllLog(@PathVariable int page,ModelMap map){
		List<Log> logList=this.logservice.getAllLog(page*5, 10);//默认每页显示五条记录，第几页就从page*5开始查询，就是当前页记录
		int pageSum=this.logservice.sum()/5+1;//获取总共的页数
		map.addAttribute("logList", logList);
		map.addAttribute("pageSum", pageSum);
		return "/SysLog/allLog";
	}
} 
