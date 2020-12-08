package com.learning.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.Date;

@Component
@EnableScheduling
public class BaseProducer{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    private static final Log log = LogFactory.getLog(BaseProducer.class);


    @Scheduled(fixedDelay = 5000)
    public void sendMsg() {
        log.info(String.format("demoSubscriber message text : %s", new Date().toString()));
        jmsMessagingTemplate.convertAndSend(queue, "测试"+new Date().toString());
    }

    public void sendMsg(String destination, String message) {
        System.out.println("111");
        System.out.println("222");
        System.out.println("555");
        System.out.println("777");
        System.out.println("888");
        System.out.println("666");
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(destination), "测试"+new Date().toString());
    }
}
