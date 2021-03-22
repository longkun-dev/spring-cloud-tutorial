package com.cloud.serviceribbon.service;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  03-21-2021 18:59:10
 * @description :  测试逻辑类
 * @since :  v1.0
 */
public interface TestService {

    /**
     * 负载均衡测试
     *
     * @param paramStr 字符串参数
     * @return String
     */
    String testService(String paramStr);

    /**
     * 调用发生错误时的处理
     *
     * @param paramStr 请求参数
     * @return 错误处理
     */
    String onError(String paramStr);
}
