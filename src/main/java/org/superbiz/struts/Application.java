package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

@SpringBootApplication
public class Application {

    public static  void  main(String args[]){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    FilterRegistrationBean siteMeshFilter(){
        Filter siteMeshFilter = new SiteMeshFilter();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.addUrlMappings("/*");
        return new FilterRegistrationBean(siteMeshFilter, registrationBean);
    }

    @Bean
    FilterRegistrationBean strutsPrepareAndExecuteFilter(){
        Filter strutsPrepareAndExecuteFilter = new StrutsPrepareAndExecuteFilter();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.addUrlMappings("/");
        registrationBean.addUrlMappings("/addUserForm.action");
        registrationBean.addUrlMappings("/addUser.action");
        registrationBean.addUrlMappings("/findUserForm.action");
        registrationBean.addUrlMappings("/findUser.action");
        registrationBean.addUrlMappings("/listAllUsers.action");

        return new FilterRegistrationBean(strutsPrepareAndExecuteFilter, registrationBean);
    }


}
