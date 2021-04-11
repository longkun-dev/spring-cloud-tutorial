package com.cloud.configserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-25-2021 00:29:41
 * @description :  配置中心配置读取测试
 * @since :  v1.0
 */
@RestController
@RequestMapping("/config/server")
public class ConfigTestController {

    //    @Value("${config.param1}")
    private String configParam1;

    @GetMapping("/param1")
    public String param1() {
        return configParam1;
    }
}
