package com.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-25-2021 00:48:16
 * @description :  配置中心测试
 * @since :  v1.0
 */
@RestController
@RequestMapping("/config/client")
public class TestController {

    // 配置文件的名称为bootstrap.properties
    @Value("${config.param1}")
    private String configParam1;

    @GetMapping(value = "/config/param1")
    public String configParam1() {
        return configParam1;
    }
}
