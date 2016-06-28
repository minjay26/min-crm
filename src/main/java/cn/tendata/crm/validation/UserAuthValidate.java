package cn.tendata.crm.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.tendata.crm.entities.User;

public class UserAuthValidate implements Validator{
	

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors er) {
		User loginUser=(User)obj;
          String account=loginUser.getAccount();
          String password=loginUser.getPassword();
          if (null==account||"".equals(account)) {
			er.rejectValue("account",null,null, "账号为空");
		}
          if (null==password||"".equals(password)) {
			er.rejectValue("password",null,null, "密码为空");
		}
			
		
	}
       
}
