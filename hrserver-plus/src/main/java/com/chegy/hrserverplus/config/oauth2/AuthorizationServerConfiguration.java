//package com.chegy.hrserverplus.config.oauth2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * 配置授权服务器
// */
//@Configuration
//@EnableAuthorizationServer //开启授权服务器
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    AuthenticationManager authenticationManager;//该对象用来支持password模式
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory; //该对象用来完成Redis缓存，将令牌信息存储到缓存中
//    @Autowired
//    UserDetailsService userDetailsService; //该对象为刷新token提供支持
//
//    //密码加密，BCrypt强哈希函数
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        //配置password授权模式，authorizedGrantTypes表示授权模式两种“password”和“refresh_token”两种
//        //accessTokenValiditySeconds方法配置access_token的过期时间
//        //resourceIds 配置了资源id
//        //secret方法配置了加密后的密码，明文是123
//        clients.inMemory()
//                .withClient("password")
//                .authorizedGrantTypes("password", "refresh_token")
//                .accessTokenValiditySeconds(1800)
//                .resourceIds("rid")
//                .scopes("all")
//                .secret("$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm");
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .tokenStore(new RedisTokenStore(redisConnectionFactory))
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        //允许表单认证,表示支持client_id和client_secret做登录认证
//        oauthServer.allowFormAuthenticationForClients();
//    }
//
//}