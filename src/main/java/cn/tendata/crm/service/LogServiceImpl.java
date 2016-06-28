package cn.tendata.crm.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tendata.crm.repository.LogRepository;
import cn.tendata.crm.response.Log;

@Service
public class LogServiceImpl implements LogService{
	
	@Autowired
	private LogRepository logRepository;

	@Override
	public List<Log> getAllLog(Integer page, Integer size) {
		List<Log> list=new ArrayList<>();
		List<Object> objects=this.logRepository.getAllLog(page,size);//从logRepository获得的Object的list集合
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for (Object obj : objects) {
			Object[] item=(Object[]) obj;//每一个Object都可以是一个数据库中查询的一条记录中所有属性的数组
			Log log=new Log();
			log.setNum(String.valueOf(item[0]));//将数组中与log对象相对应的属性set进去，即获得一个log实例对象		
			log.setLogDesc(String.valueOf(item[2]));
			/**
			 * 因为从数据库中取出的时间是一个timestamp类型，需要进行转换
			 */
			Timestamp timestamp=new Timestamp(Long.valueOf(String.valueOf(item[1])) );
			log.setLogTime(sdf.format(timestamp));
			list.add(log);
		}
		return list;
	}
    
	/**
	 * 获得所有日志记录条数
	 */
	@Override
	public int sum() {
      return (int) this.logRepository.sum();
	}

}
