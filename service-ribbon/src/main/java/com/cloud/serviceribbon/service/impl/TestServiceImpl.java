package com.cloud.serviceribbon.service.impl;

import com.cloud.serviceribbon.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-21-2021 19:00:18
 * @description :  测试业务实现类
 * @since :  v1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "onError")
    @Override
    public String testService(String paramStr) {
        return restTemplate.getForObject("http://EUREKA-CLIENT1/client/test?paramStr=" + paramStr,
                String.class);
    }

    @Override
    public String onError(String paramStr) {
        return "on error! param is " + paramStr;
    }
}
