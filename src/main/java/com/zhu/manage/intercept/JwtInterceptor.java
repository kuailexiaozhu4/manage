package com.zhu.manage.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuwulong
 * @date 2023年04月
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof JwtInterceptor)) {
            return true;
        }
        // 获取请求头token
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            return false;
        }
        // 解析token
//        Claims claims = JwtUtil.parseJWT(token);
//        if (claims == null) {
//            return false;
//        }
//        // 获取用户信息
//        String username = claims.getSubject();
//        if (username == null || username.isEmpty()) {
//            return false;
//        }
        // 放行
        return true;
    }
}
