package com.learning.activemq;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class SaveSubscriber{

    private static final Log log = LogFactory.getLog(SaveSubscriber.class);

    @JmsListener(destination = "${defaultTopic}", containerFactory = "jmsListenerContainerTopic")
    public void subscribe(String text) {
        log.info(String.format("receive defaultTopic msg:%s",text));
    }
}
