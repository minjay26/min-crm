package cn.tendata.crm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MyApplication extends SpringBootServletInitializer{
	
 
     public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	
	}
     
     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(MyApplication.class) ;
    }
}
