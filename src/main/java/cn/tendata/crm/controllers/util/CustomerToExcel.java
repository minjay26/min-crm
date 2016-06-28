package cn.tendata.crm.controllers.util;

import java.io.File;
import java.util.List;

import cn.tendata.crm.entities.Customer;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CustomerToExcel {
     public static void toExcel(List<Customer> list){
    	 try {
 			WritableWorkbook wwb = null;

 			// 创建可写入的Excel工作簿
 			String fileName = "D://allCustomer.xls";
 			File file = new File(fileName);
 			if (!file.exists()) {
 				file.createNewFile();
 			}
 			// 以fileName为文件名来创建一个Workbook
 			wwb = Workbook.createWorkbook(file);

 			// 创建工作表
 			WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
 			// 要插入到的Excel表格的行号，默认从0开始
 			Label labelName = new Label(0, 0, "姓名");// 表示第
 			Label labelAddress = new Label(1, 0, "地址");
 			Label labelCompany = new Label(2, 0, "公司");
 			Label labelGender= new Label(3, 0, "性别");
 			Label labelJoinTime= new Label(4, 0, "合作开始时间");
 			Label labelPhone= new Label(5, 0, "电话号码");
 			Label labelSalesman= new Label(6, 0, "负责人");
 			Label labelType= new Label(7, 0, "类型");

 			ws.addCell(labelName);
 			ws.addCell(labelAddress);
 			ws.addCell(labelCompany);
 			ws.addCell(labelGender);
 			ws.addCell(labelJoinTime);
 			ws.addCell(labelPhone);
 			ws.addCell(labelSalesman);
 			ws.addCell(labelType);
 			for (int i = 0; i < list.size(); i++) {

 				Label labelName_i = new Label(0, i + 1, list.get(i).getCustomerName() + "");
 				Label labelAddress_i = new Label(1, i + 1, list.get(i).getAddress());
 				Label labelCompany_i = new Label(2, i + 1, list.get(i).getCompany());
 				Label labelSex_i = new Label(3, i + 1, list.get(i).getGender() + "");
 				Label labelJointime_i = new Label(4, i + 1, list.get(i).getJoinTime() + "");
 				Label labelPhone_i = new Label(5, i + 1, list.get(i).getPhone() + "");
 				Label labelSalesman_i = new Label(6, i + 1, list.get(i).getsId() + "");
 				Label labelType_i = new Label(7, i + 1, list.get(i).getType() + "");
 				ws.addCell(labelName_i);
 				ws.addCell(labelAddress_i);
 				ws.addCell(labelCompany_i);
 				ws.addCell(labelSex_i);
 				ws.addCell(labelJointime_i);
 				ws.addCell(labelPhone_i);
 				ws.addCell(labelSalesman_i);
 				ws.addCell(labelType_i);
 				
 			}

 			// 写进文档
 			wwb.write();
 			// 关闭Excel工作簿对象
 			wwb.close();

 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }
}
