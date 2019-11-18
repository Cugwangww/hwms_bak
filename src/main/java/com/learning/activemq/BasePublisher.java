package com.learning.activemq;

import com.learning.task.TaskHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.Date;

@Component
@EnableScheduling
public class BasePublisher{

    private static final Log log = LogFactory.getLog(BasePublisher.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 5000)
    public void publish() {
        log.info(String.format("send publisher msg:%s",System.currentTimeMillis()+""));
        jmsMessagingTemplate.convertAndSend(topic, new Date().toString());
    }

    public void publish(String destiantion, String message) {
        jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(destiantion), message);
    }
}
