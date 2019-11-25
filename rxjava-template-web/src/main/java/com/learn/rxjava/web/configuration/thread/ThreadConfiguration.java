package com.learn.rxjava.web.configuration.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadConfiguration {
    @Bean
    public Scheduler schedulerMongo(MongoThreadConfiguration configuration) {
        return get(configuration, "mongo");
    }

    @Bean
    public Scheduler schedulerOutbound(OutboundThreadConfiguration configuration) {
        return get(configuration, "outbound");
    }

    private Scheduler get(BaseThreadConfiguration configuration, String prefix) {
        Integer minIdle =
            configuration.getMinIdleThread() != null ? configuration.getMinIdleThread() : 0;
        Integer maxThread =
            configuration.getMaxThread() != null ? configuration.getMaxThread() : Integer.MAX_VALUE;
        Integer ttl =
            configuration.getThreadTtl() != null ? configuration.getThreadTtl() : 0;
        Integer maxQueue =
            configuration.getMaxQueue() != null ? configuration.getMaxQueue() : Integer.MAX_VALUE;

        return Schedulers.from(
            new ThreadPoolExecutor(
                minIdle,
                maxThread,
                ttl,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(maxQueue),
                new NamingThreadFactory(prefix)));
    }
}
