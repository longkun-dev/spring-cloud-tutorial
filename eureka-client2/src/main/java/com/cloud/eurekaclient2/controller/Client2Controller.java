package com.cloud.eurekaclient2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-21-2021 18:02:46
 * @description :  接口测试类2
 * @since :  v1.0
 */
@RequestMapping("/client")
@RestController
public class Client2Controller {

    @RequestMapping("/test")
    public String client2Test() {
        return "Client2 return success!";
    }
}
