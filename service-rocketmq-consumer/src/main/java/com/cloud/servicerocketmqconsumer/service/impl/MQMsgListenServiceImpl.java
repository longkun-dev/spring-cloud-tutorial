package com.cloud.servicerocketmqconsumer.service.impl;

import com.cloud.servicerocketmqconsumer.service.MQMsgListenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/11 2:43 PM
 */
@Service
@Slf4j
public class MQMsgListenServiceImpl implements MQMsgListenService {
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgList)) {
            log.info("rocketmq message is empty");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgList.get(0);
        log.info("MQ接收到的消息为: {}", messageExt.toString());
        try {
            String topic = messageExt.getTopic();
            String tags = messageExt.getTags();
            String body = new String(messageExt.getBody(), StandardCharsets.UTF_8);
            log.info("mq消息topic={}, tags={}, content={}", topic, tags, body);
        } catch (Exception e) {
            log.error("get message exception");
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
