package com.learn.rxjava.web.configuration.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamingThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    public NamingThreadFactory(String prefix) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix =
            new StringBuilder(prefix)
                .append("-")
                .append(poolNumber.getAndIncrement())
                .append("-thread-")
                .toString();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
            new StringBuilder(namePrefix).append(threadNumber.getAndIncrement()).toString(), 0);

        if (t.isDaemon()) {
            t.setDaemon(false);
        }

        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
