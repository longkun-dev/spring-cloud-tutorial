package com.cloud.serviceribbon.service.impl;

import com.cloud.serviceribbon.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public String testService(String paramStr) {
        return restTemplate.getForObject("http://EUREKA-CLIENT1/client/test?paramStr=" + paramStr,
                String.class);
    }
}
