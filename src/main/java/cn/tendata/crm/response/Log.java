package cn.tendata.crm.response;
/**
 * 日志类
 * @author Administrator
 *
 */
public class Log {
	/**
	 * 日志序号
	 */
     private String num;
     
     /**
      * 日志描述
      */
     private String logDesc;
     
     /**
      * 日志记录时间
      */
     private String logTime;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getLogDesc() {
		return logDesc;
	}

	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Log(String num, String logDesc, String logTime) {
		super();
		this.num = num;
		this.logDesc = logDesc;
		this.logTime = logTime;
	}
     
     
}
