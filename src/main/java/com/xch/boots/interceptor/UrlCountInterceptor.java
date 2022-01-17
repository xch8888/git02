package com.xch.boots.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @package: com.xch.boots.interceptor
 * @ClassName: LoginInterceptor
 * @author: 清欢.
 * @date: 2022/1/7 13:55
 */

@Slf4j
public class UrlCountInterceptor implements HandlerInterceptor {
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            String requestURI =request.getRequestURI();
//            redisTemplate.opsForValue().increment(String.valueOf(request));
//            return true;
//    }

}
