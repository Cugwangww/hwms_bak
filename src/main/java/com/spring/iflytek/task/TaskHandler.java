package com.spring.iflytek.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class TaskHandler {
    @Scheduled(cron = "0/5 * * * * ?")
    public void  Test(){
       log.info(new Date().toString());
    }
}
