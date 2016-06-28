package cn.tendata.crm.service;

import java.util.List;

import cn.tendata.crm.response.Log;

public interface LogService {
    List<Log> getAllLog(Integer page,Integer size);
    
    int sum();
}
