package com.learning.activemq;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class SaveConsumer {

    private static final Log log = LogFactory.getLog(SaveSubscriber.class);

    @JmsListener(destination = "${defaultQueue}", containerFactory = "jmsListenerContainerQueue")
    public void receiveMsg(String text) {
        try {
            log.info(String.format("receive defaultQueue msg:%s",text));
        } catch (Exception e) {
        }
    }
}
