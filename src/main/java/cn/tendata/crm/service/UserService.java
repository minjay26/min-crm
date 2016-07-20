package cn.tendata.crm.service;



import org.springframework.data.domain.Page;

import cn.tendata.crm.entities.User;

public interface UserService {
      User getByAccount(String account);
      
      User getByUsername(String username);
      
      Page<User> getDepartment_users(int dpId,int page,int size);
      
      void add(User user);
      
      void updata(User user);
      
      User get(int sId);

	void addUserNumOfDp(int dpId);

	  void remove(int sId);
}
