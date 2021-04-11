package com.cloud.servicerocketmqprovider.config;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/11 2:04 PM
 */
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
@Slf4j
public class MQProducerConfig {

    private String groupName;

    private String namesrvAddr;

    /**
     * 消息最大值
     */
    private Integer maxMsgSize;

    /**
     * 发送消息超时时间
     */
    private Integer sendMsgTimeOut;

    /**
     * 最大重试次数
     */
    private Integer retryTimesWhenSendFailed;

    /**
     * mq生产者配置
     *
     * @return defaultProducer
     * @throws MQClientException MQClientException
     */
    @Bean
    @ConditionalOnProperty(prefix = "rocketmq.producer", value = "isOnOff", havingValue = "on")
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        log.info("default producer is creating");
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setMaxMessageSize(maxMsgSize);
        producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);
        producer.setSendMsgTimeout(sendMsgTimeOut);
        producer.setVipChannelEnabled(false);
        producer.start();
        log.info("rocketmq producer server started");
        return producer;
    }
}
