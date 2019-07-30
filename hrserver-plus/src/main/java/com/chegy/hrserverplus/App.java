package com.chegy.hrserverplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.chegy.hrserverplus"})
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.chegy.hrserverplus.mapper")//或者直接在 Mapper 类上面添加注解@Mapper
//@EnableScheduling
@EnableCaching
// 启动类必须加入@ServletComponentScan注解，否则无法扫描到servlet
@ServletComponentScan
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}

