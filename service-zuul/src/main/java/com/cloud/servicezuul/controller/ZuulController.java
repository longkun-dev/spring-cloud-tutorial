package com.cloud.servicezuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-23-2021 23:56:46
 * @description :  Zuul接口类
 * @since :  v1.0
 */
@RestController
@RequestMapping("/zuul")
public class ZuulController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
