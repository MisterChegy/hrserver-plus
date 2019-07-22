package com.chegy.hrserverplus;

import com.chegy.hrserverplus.mapper.HrMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.chegy.hrserverplus.mapper")//或者直接在 Mapper 类上面添加注解@Mapper
public class HrserverPlusApplicationTests {

    @Autowired
    private HrMapper hrMapper;

    /*
    懒加载与急加载对比
     */
    @Test
    public void contextLoads() {
        //懒加载
//        Hr hr = hrMapper.loadUserByUsername("admin");

//        System.out.println(hr.getId());
//
//        System.out.println(hr.getRoles().size());
//        SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
////        OrdersMapperCustom ordersMapperCustom = sqlSession
////                .getMapper(OrdersMapperCustom.class);
//        HrMapper hrMapper = sqlSession.getMapper(HrMapper.class);
//        //查询单表
//        hrMapper.loadUserByUsername("admin");
    }

}
