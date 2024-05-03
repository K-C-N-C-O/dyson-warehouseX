package com.dyson.warehouseX.manager.config;

import com.dyson.warehouseX.manager.interceptor.LoginAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginAuthInterceptor loginAuthInterceptor;


    //拦截器注册
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginAuthInterceptor)
                .excludePathPatterns("/admin/system/index/login")
                //.excludePathPatterns("/**")
                .addPathPatterns("/**");
    }


    //跨域
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")      // 添加路径规则
                .allowCredentials(true)               // 是否允许在跨域的情况下传递Cookie
                .allowedOriginPatterns("*")           // 允许请求来源的域规则
                .allowedMethods("*")
                .allowedHeaders("*");                // 允许所有的请求头
    }

}
