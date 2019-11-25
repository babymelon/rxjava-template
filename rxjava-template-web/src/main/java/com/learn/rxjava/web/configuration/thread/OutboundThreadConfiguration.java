package com.learn.rxjava.web.configuration.thread;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "base.thread.outbound")
public class OutboundThreadConfiguration extends BaseThreadConfiguration {
}
