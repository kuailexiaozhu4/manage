package com.zhu.manage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhuwulong
 * @date 2023年03月
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        添加跨域设置
        registry.addMapping("/**")
//                所有域名被允许(高版本)
//                .allowedOriginPatterns("*")
//                所有域名被允许(低版本)
                .allowedOrigins("*")
                //项目需要带凭证
                //.allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*")
//                允许所有头
                .allowedHeaders("*");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//// 添加拦截器
//        registry.addInterceptor(jwtInterceptor())
//                //拦截所有路径
//                .addPathPatterns("/**")
//                //放行
//                .excludePathPatterns("/user/login", "/user/register");
//    }
//
//    //jwt拦截器
//    @Bean
//    public JwtInterceptor jwtInterceptor() {
//        return new JwtInterceptor();
//    }
}
