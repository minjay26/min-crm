package cn.tendata.crm.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.tendata.crm.entities.Reimbursement;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer>{
        List<Reimbursement> findByStatus(String status);
        Page<Reimbursement> findAll(Pageable pageable);
        Page<Reimbursement> findByCreatTimeAfterAndCreatTimeBefore(Date begin,Date end,Pageable pageable);
}
