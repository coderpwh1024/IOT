package com.coderpwh.http.quota.host;

import com.coderpwh.http.quota.inmemory.IntervalRegistryCleaner;
import com.coderpwh.http.quota.inmemory.KeyBasedIntervalRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author coderpwh
 */
@Component
@Slf4j
public class HostIntervalRegistryCleaner extends IntervalRegistryCleaner {


    @Value("${quota.host.cleanPeriodMs}")
    private Long cleanPeriodMs;


    public HostIntervalRegistryCleaner(HostRequestIntervalRegistry intervalCleaner) {
        super(intervalCleaner,0);
    }


}
