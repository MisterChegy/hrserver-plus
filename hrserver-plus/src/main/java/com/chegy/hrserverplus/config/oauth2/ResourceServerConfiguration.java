//package com.chegy.hrserverplus.config.oauth2;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
///**
// * 配置资源服务器
// */
//@Configuration
//@EnableResourceServer //开启资源服务器配置
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        /**
//         * 配置资源id，这里的资源id和授权资源服务器中的资源id一致，然后设置这些资源仅基于令牌认证
//         */
//        resources.resourceId("rid").stateless(true);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http.authorizeRequests()
//                .anyRequest().permitAll();
//    }
//}
