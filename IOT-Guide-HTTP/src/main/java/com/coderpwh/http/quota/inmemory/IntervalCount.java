package com.coderpwh.http.quota.inmemory;

import com.coderpwh.http.quota.Clock;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author coderpwh
 */
public class IntervalCount {

    private final LongAdder adder = new LongAdder();

    private final long interalDurationMs;

    private volatile long startTime;

    private volatile long lastTickTime;

    public IntervalCount(long interalDurationMs) {
        this.interalDurationMs = interalDurationMs;
        startTime = Clock.millis();
    }

    public long resetIfExpiredAndTick(){
        if(isExpired()){
            reset();
        }
        tick();
        return  adder.sum();
    }

    public  long silenceDuration(){
        return  Clock.millis()-lastTickTime;
    }

    public long getCount() {
        return adder.sum();
    }


    private void tick() {
        adder.add(1);
        lastTickTime = Clock.millis();
    }

    private void reset() {
        adder.reset();
        lastTickTime = Clock.millis();
    }


    /***
     * 判断是否过期
     * @return
     */
    private boolean isExpired() {
        return (Clock.millis() - startTime) > interalDurationMs;
    }

}
