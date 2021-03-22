package com.cloud.servicefeign.controller;

import com.cloud.servicefeign.feign.FeignTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-23-2021 00:14:47
 * @description :  Feign调用接口类
 * @since :  v1.0
 */
@RestController
@RequestMapping("/feign/client")
public class FeignController {

    @Resource
    private FeignTest feignTest;

    @GetMapping("/test")
    public String feignTest(@RequestParam String name) {
        return feignTest.clientTest(name);
    }
}
