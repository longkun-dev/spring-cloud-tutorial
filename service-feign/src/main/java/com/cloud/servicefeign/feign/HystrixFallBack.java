package com.cloud.servicefeign.feign;

import org.springframework.stereotype.Service;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-23-2021 00:34:50
 * @description :  Hystrix失败回调方法
 * @since :  v1.0
 */
@Service
public class HystrixFallBack implements FeignTest {
    @Override
    public String clientTest(String name) {
        return "on error! param is " + name;
    }
}
