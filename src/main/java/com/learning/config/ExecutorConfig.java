package com.learning.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author wwwang7
 * @Date 2019/5/9 15:56
 */
@Configuration
public class ExecutorConfig {
    private static Log logger = LogFactory.getLog(ExecutorConfig.class);
    /**
     * 线程池的核心线程数
     */
    @Value("${async.executor.thread.corePoolSize}")
    private int corePoolSize;
    /**
     * 线程池最大线程数
     */
    @Value("${async.executor.thread.maximumPoolSizeSize}")
    private int maximumPoolSizeSize;
    /**
     * 线程活动保持时间
     */
    @Value("${async.executor.thread.keepAliveTime}")
    private int keepAliveTime;
    /**
     * 任务队列大小
     */
    @Value("${async.executor.thread.queueCapacity}")
    private int queueCapacity;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maximumPoolSizeSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-service-");
        //设置活跃时间
        executor.setKeepAliveSeconds(keepAliveTime);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
