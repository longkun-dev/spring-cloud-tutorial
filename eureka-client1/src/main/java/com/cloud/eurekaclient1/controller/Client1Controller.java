package com.cloud.eurekaclient1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-21-2021 18:01:10
 * @description :  接口测试类1
 * @since :  v1.0
 */
@RequestMapping("/client")
@RestController
public class Client1Controller {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/test")
    public String TestClient1(@RequestParam String paramStr) {
        return "param is " + paramStr + ", return success! run on " + port;
    }
}
