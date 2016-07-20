package cn.tendata.crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
	   
	/**
	 * 注册一个视图解析器
	 * @return
	 */
//	   @Bean
//      public InternalResourceViewResolver viewResolver(){
//    	  InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
//    	  /**
//    	   * 设置视图访问路径的前缀和后缀
//    	   */
//    	  viewResolver.setPrefix("/WEB-INF/jsp");
//    	  viewResolver.setSuffix(".jsp");
//    	  viewResolver.setViewClass(JstlView.class);
//    	  return viewResolver;
//      }
      
      @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    	configurer.setUseSuffixPatternMatch(false);
    }
      
     
}
