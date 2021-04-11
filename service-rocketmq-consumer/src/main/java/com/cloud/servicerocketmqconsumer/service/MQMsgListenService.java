package com.cloud.servicerocketmqconsumer.service;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/11 2:40 PM
 */
public interface MQMsgListenService {

    /**
     * 默认msg里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
     * 不要抛异常，如果没有return CONSUME_SUCCESS ，consumer会重新消费该消息，
     * 直到return CONSUME_SUCCESS
     *
     * @return ConsumeConcurrentlyStatus
     */
    ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext context);

}
