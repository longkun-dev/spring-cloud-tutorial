package com.cloud.servicerocketmqprovider.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/11 3:08 PM
 */
@RestController
@RequestMapping("/mq/provider")
public class SendController {

    public static final Logger LOGGER = LoggerFactory.getLogger(SendController.class);

    @Autowired
    private DefaultMQProducer producer;

    @GetMapping("/send")
    public void send(String message) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        if (StringUtils.isEmpty(message)) {
            return;
        }
        Message sendMsg = new Message("TestTopic", "TestTag", message.getBytes());
        // 默认3秒超时
        SendResult sendResult = producer.send(sendMsg);
        LOGGER.info("消息发送响应：" + sendResult.toString());
    }
}
