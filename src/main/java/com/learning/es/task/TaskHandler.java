package com.learning.es.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskHandler {

    private static final Log log = LogFactory.getLog(TaskHandler.class);
    @Scheduled(cron = "0/30 * * * * ?")
    public void  Test(){
       log.info(new Date().toString());
    }
}
