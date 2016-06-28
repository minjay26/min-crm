package cn.tendata.crm.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tendata.crm.controllers.util.GetCurrentInfo;
import cn.tendata.crm.entities.Reimbursement;
import cn.tendata.crm.entities.User;
import cn.tendata.crm.service.ReimbursementService;
import cn.tendata.crm.service.UserService;

@Controller
public class ReimbursementController {
      
	@Autowired
	private ReimbursementService reimbursementService;
	
	@Autowired
	private GetCurrentInfo getCurrentInfo;
    
	@Autowired
	private UserService userservice;
//	@Autowired
//    private GetCurrentInfo currentInfo;
	
	@RequestMapping("/reimbursement")
	public String reimbursementMsg(ModelMap map){
//		UserDetails user=this.currentInfo.getCurrentInfo();
//		String role=user.getAuthorities().toString();		
        
		//List<Reimbursement> list=this.reimbursementService.auditedRb("未审核");
		//map.addAttribute("list",list);
		return "/reimbursement/adminManageRb";	
	}
	
	@RequestMapping("/personReimbursement")
     public String personReimbursement(){
		return "/reimbursement/personReimbursement";
    	 
     }
	
	/*
	 * 查询未审核的报销
	 */
	@RequestMapping("/noCheck")
	public String check(ModelMap map){
		List<Reimbursement> list=this.reimbursementService.auditedRb("未审核");
		map.addAttribute("list",list);
		return "/reimbursement/query";		
	}
	
	/*
	 * 审核报销，结果为审核通过或者未能报批
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/checkPass/{rbId}/{identity}")
	@ResponseBody
	public String checkPass(@PathVariable Integer rbId,@PathVariable Integer identity){
		String status=null;
		if (identity==0) {
			status="审核通过";
		}else {
		    status="未能报批";
		}
      this.reimbursementService.check(status, rbId);
		return "{result:true,message:\"操作成功\"}";		
	}
	
	@RequestMapping("/queryReimbursementPage/{page}")
	public String allReimbursement(@PathVariable Integer page,ModelMap map){
		Page<Reimbursement> pageContent=this.reimbursementService.getAll(page,5);
		List<Reimbursement> list=pageContent.getContent();
		int pageSum=pageContent.getTotalPages();
		map.addAttribute("list",list);
		map.addAttribute("pageSum",pageSum);
		map.addAttribute("url", "queryReimbursementPage");
		return "/reimbursement/query";
	}
	
	
	@RequestMapping("/queryByDate/{page}")
	public String queryByDate(@PathVariable Integer page,String beginTime,String endTime,ModelMap map){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
             Date begin = null;
             Date end = null;
			try {
				begin = sdf.parse(beginTime);
			    end=sdf.parse(endTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	Page<Reimbursement> pageContent=this.reimbursementService.queryByDate(page, 5, begin, end);
			List<Reimbursement> list=pageContent.getContent();
			int pageSum=pageContent.getTotalPages();
			map.addAttribute("pageSum",pageSum);
			map.addAttribute("list", list);
			map.addAttribute("url", "queryByDate");
	
		return "/reimbursement/query";
	}
	
	
	 @RequestMapping(value="/person_apply",method=RequestMethod.GET)
	 public String person_apply(){
		return "/reimbursement/person_apply";
	}
	 
	 
	 @RequestMapping(value="/person_apply",method=RequestMethod.POST)
	 @ResponseBody
	 public String person_apply(Reimbursement reimbursement){
		Date creatTime=new Date();
		UserDetails user=this.getCurrentInfo.getCurrentInfo();
		User applicant=this.userservice.getByUsername(user.getUsername());
		reimbursement.setApplicant(applicant);
		reimbursement.setCreatTime(creatTime);
		reimbursement.setStatus("未审核");
		this.reimbursementService.apply(reimbursement);
		
		return "{result:true,message:\"申请成功\"}";
		//reimbursement.setApplicant(user);
		
	}
}
