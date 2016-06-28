package cn.tendata.crm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tendata.crm.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByAccount(String account);

	
	User findByUsername(String username);
	
    Page<User> findByDpId(int dpId,Pageable pageable);
    
    /**
     * 每增加一个员工，相对应部门人数加一
     * @param dpId
     */
   @Modifying
   @Transactional(propagation=Propagation.REQUIRED)
   @Query(value="update department set num_of_employess=num_of_employess+1 where dp_id=:dpId",nativeQuery=true)
   void addUserNumOfDp(@Param("dpId") int dpId);
}
