package com.coderpwh.http.quota.inmemory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author coderpwh
 */

@Slf4j
public abstract class IntervalRegistryCleaner {


    private final KeyBasedIntervalRegistry intervalRegistry;

    private final long cleanPeriodMs;

    private ScheduledExecutorService executorService;

    public IntervalRegistryCleaner(KeyBasedIntervalRegistry intervalRegistry, long cleanPeriodMs) {
        this.intervalRegistry = intervalRegistry;
        this.cleanPeriodMs = cleanPeriodMs;
    }


    public void schedule(){
        if(executorService!=null){
            throw new IllegalStateException("Registry Cleaner already scheduled");
        }
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::clean,cleanPeriodMs,cleanPeriodMs, TimeUnit.MICROSECONDS);
    }



    public void stop() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public void clean() {
        try {
            intervalRegistry.clean();
        } catch (RuntimeException ex) {
            log.error("Cloud not clear Interval Registry", ex);
        }
    }


}
