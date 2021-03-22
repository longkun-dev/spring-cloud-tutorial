package com.cloud.servicefeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-23-2021 00:11:30
 * @description :  Feign调用测试类
 * @since :  v1.0
 */
@FeignClient(value = "EUREKA-CLIENT1", fallback = HystrixFallBack.class)
public interface FeignTest {

    @GetMapping(value = "/client/test")
    String clientTest(@RequestParam(value = "paramStr") String name);

}
