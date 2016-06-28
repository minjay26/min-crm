package cn.tendata.crm.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Controller
public class LoginController {
	
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LoginController.class);
	
//	@Autowired
//	private UserService userService;
//
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(new UserAuthValidate());
//	}
	
   /**
    * 登录路径
    * @return
    */
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@Validated User LoginUser, BindingResult result,HttpSession session,ModelMap map) {
//		if (result.hasErrors()) {
//			return "/login";
//		}		
//		User user=userService.getByAccount(LoginUser.getAccount());
//        if (null==user) {
//			map.addAttribute("msg", "该账号不存在");
//			return "/login";
//		}
//        if (!LoginUser.getPassword().equals(user.getPassword())) {
//        	map.addAttribute("msg", "账号与密码不匹配");
//        	return "/login";
//		}
//        session.setAttribute("user", user);
//        LOGGER.info("user:{},登录了)",user.getUsername());
//        return "redirect:/home";
//	}
//	@RequestMapping("/login2")
//	public String Test(@SessionScope("currentUser") Employee employee){
//		if (employee==null||employee.getsId()==0) {
//			return "/login";
//		}else {
//			return "/index";
//		}
//	}

//	@ModelAttribute("user")
//	public User get() {
//		return new User();
//	}
}
