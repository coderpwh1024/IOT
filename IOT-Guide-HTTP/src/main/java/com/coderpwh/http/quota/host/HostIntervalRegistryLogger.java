package com.coderpwh.http.quota.host;

import com.coderpwh.http.quota.inmemory.IntervalRegistryLogger;
import com.coderpwh.http.quota.inmemory.KeyBasedIntervalRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author coderpwh
 */
@Slf4j
public class HostIntervalRegistryLogger extends IntervalRegistryLogger {



    public HostIntervalRegistryLogger(int topSize, KeyBasedIntervalRegistry intervalRegistry, long logIntervalMin) {
        super(topSize, intervalRegistry, logIntervalMin);
    }

    @Override
    protected void log(Map<String, Long> top, int uniqHosts, long requestsCount) {

    }
}
