package hska.iwi.eShopMaster;

import hska.iwi.eShopMaster.restclient.CategoryCoreFallback;
import hska.iwi.eShopMaster.restclient.ProductCoreFallback;
import hska.iwi.eShopMaster.restclient.RoleCoreFallback;
import hska.iwi.eShopMaster.restclient.UserCoreFallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@ServletComponentScan
@EnableFeignClients
@ComponentScan(basePackages = {"hska.iwi.eShopMaster.model.businessLogic.manager.impl", "hska.iwi.eShopMaster.controller"})
public class WebshopUiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebshopUiApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("Im starting");
        SpringApplication.run(WebshopUiApplication.class, args);
    }

    @Bean
    public ProductCoreFallback productCoreFallback() {
        return new ProductCoreFallback();
    }

    @Bean
    public CategoryCoreFallback categoryCoreFallback() {
        return new CategoryCoreFallback();
    }

    @Bean
    public RoleCoreFallback roleCoreFallback() {
        return new RoleCoreFallback();
    }

    @Bean
    public UserCoreFallback userCoreFallback() {
        return new UserCoreFallback();
    }

   /** @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
        registrationBean.setFilter(struts);
        registrationBean.setOrder(1);
        return registrationBean;
    }
**/
}