package cn.tendata.crm.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import cn.tendata.crm.entities.Reimbursement;

public interface ReimbursementService {
     List<Reimbursement> auditedRb(String status);
     
     void check(String status,Integer rbId);
     
     Page<Reimbursement> getAll(Integer page,Integer size);
     
     Page<Reimbursement> queryByDate(Integer page,Integer size,Date begin,Date end);
     
     void apply(Reimbursement reimbursement);
}
