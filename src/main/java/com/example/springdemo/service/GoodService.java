package com.example.springdemo.service;

import org.apache.catalina.LifecycleState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//必须加入component注解 否则在controller层无法注入，加入component 把对象创建交给spring完成
@Component
//加入这个注解 并且name值必须与被调用服务注册在注册中心上的名称一致
@FeignClient(name = "HONGSHEN-WEAVING")

public interface GoodService {
    //这个value值要与被调用的服务里面的路径一致
    @RequestMapping(value = "/myTest/getGoodByID",method = RequestMethod.GET)
    //记住加入@RequestParam("goodID")  否则会报错（500）
    String findByID(@RequestParam("goodID") int goodID);

    //返回所有的商品列表
    @RequestMapping("/myTest/selectAll")
    List selectAllGood();
}
