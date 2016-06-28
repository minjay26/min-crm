package cn.tendata.crm.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;
import cn.tendata.crm.controllers.util.GetCurrentInfo;
import cn.tendata.crm.entities.Product;
import cn.tendata.crm.service.ProductService;
/**
 * 商品控制类
 * @author Administrator
 *
 */
@Controller
public class ProductController {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LoginController.class);
     
	@Autowired
	private ProductService productService;
	
	/**
	 * 自动注入当前登录用户信息组件
	 */
	@Autowired
    private GetCurrentInfo currentInfo;

    /**
     * 修改商品信息
     */
	@RequestMapping(value="/product-modify/{pId}",method=RequestMethod.GET)
	public String modify(@PathVariable int pId,ModelMap map){
		
		Product currentProduct=this.productService.get(pId);
		map.addAttribute("currentProduct", currentProduct);
		
		return "/product/modify";
	}
	
	@RequestMapping(value="/product-modify",method=RequestMethod.POST)
	@ResponseBody
	public String modify(Product product){
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
	    LOGGER.warn("{}修改了商品：{}的信息",currentUser.getUsername(),product.getpName());
	  this.productService.modify(product);
	  return "{result:true,message:\"修改成功\"}";
		
	}
	
	/**
	 * 删除某件商品
	 * @param dpId
	 * @return
	 */
	@RequestMapping("/product-remove/{dpId}")
	@ResponseBody
	public String remove(@PathVariable int dpId){
		this.productService.remove(dpId);
		Product product=this.productService.get(dpId);
		UserDetails currentUser=this.currentInfo.getCurrentInfo();//获取当前登录用户
	    LOGGER.warn("{}删除了商品：{}的信息",currentUser.getUsername(),product.getpName());
		return "{result:true,message:\"删除成功\"}";
	}
	
	@RequestMapping(value="/product-add",method=RequestMethod.GET)
	public String add(){
		return "/product/add";
	}
	
	/**
	 * 添加商品
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/product-add",method=RequestMethod.POST)
	@ResponseBody
	public String add(Product product){
		this.productService.add(product);
		UserDetails currentUser=this.currentInfo.getCurrentInfo();
	    LOGGER.warn("{}增加商品：{}",currentUser.getUsername(),product.getpName());
		return "{result:true,message:\"保存成功\"}";
	}
	
	@RequestMapping("/allProductWithPage/{page}")
	public String getAllWithPage(@PathVariable("page")Integer page,ModelMap map){
		Page<Product> productPage=this.productService.getAllWithPage(page, 5);
		int pageSum=productPage.getTotalPages();
		List<Product> list=productPage.getContent();
		map.addAttribute("list", list);
		map.addAttribute("pageSum", pageSum);
		map.addAttribute("page", page);
		return "/product/allProduct";
	}
}
