package com.learn.rxjava.web.configuration.thread;

import lombok.Data;

@Data
public class BaseThreadConfiguration {
    private Integer maxThread;
    private Integer minIdleThread;
    private Integer threadTtl;
    private Integer maxQueue;
}
