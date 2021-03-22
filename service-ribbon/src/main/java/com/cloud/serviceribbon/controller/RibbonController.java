package com.cloud.serviceribbon.controller;

import com.cloud.serviceribbon.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-21-2021 19:06:49
 * @description :  负载均衡测试类
 * @since :  v1.0
 */
@RequestMapping("/ribbon")
@RestController
public class RibbonController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test(@RequestParam String paramStr) {
        return testService.testService(paramStr);
    }
}
