package com.xch.boots.config;

import com.xch.boots.interceptor.LoginInterceptor;
import com.xch.boots.interceptor.UrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @package: com.xch.boots.config
 * @ClassName: AdminWebConfig
 * @author: 清欢.
 * @date: 2022/1/7 14:04
 */

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
//    @Autowired
//    UrlCountInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有请求都被拦截器包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/myplugs/**",
                        "/skin/**","/res/**","/img/**","/images/**","/js/**",
                        "/layui/**","/lay/**","/fonts/**");
//        registry.addInterceptor(interceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/myplugs/**","/skin/**","/res/**","/img/**","/images/**","/js/**");
    }
}
