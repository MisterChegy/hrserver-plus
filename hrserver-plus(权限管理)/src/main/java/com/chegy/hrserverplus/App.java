package com.chegy.hrserverplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.chegy.hrserverplus"})
@RestController
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.chegy.hrserverplus.mapper")//或者直接在 Mapper 类上面添加注解@Mapper
public class App {

    public static void main(String[] args){
        System.out.println("Hello World!");
        SpringApplication.run(App.class,args);
    }
}

