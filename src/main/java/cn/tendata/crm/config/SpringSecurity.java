package cn.tendata.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import cn.tendata.crm.service.CustomUserService;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter{
	
	/**
	 * 注册CustomUserService的Bean
	 * @return
	 */
    @Bean
    UserDetailsService customUserService(){
    	return new CustomUserService();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	/**
    	 * 添加我们自定义的user detail service认证
    	 */
    	auth.userDetailsService(customUserService());
    	
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.csrf().disable().authorizeRequests()
    	 .anyRequest().authenticated()//所有需要经过认证登录后才能访问
    	 .and()
    	 .formLogin()
    	 .loginPage("/login")//定制登录行为
    	 .defaultSuccessUrl("/home")
    	 .permitAll()
    	 .and()
    	 .logout().deleteCookies().invalidateHttpSession(true).permitAll();
    
    }
}
