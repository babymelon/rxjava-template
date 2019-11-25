package com.learn.rxjava.web.configuration.thread;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "base.thread.mongo")
public class MongoThreadConfiguration extends BaseThreadConfiguration {
}
