package com.coderpwh.http.quota.host;

import com.coderpwh.http.quota.inmemory.KeyBasedIntervalRegistry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author coderpwh
 */
@Component
@Slf4j
public class HostRequestIntervalRegistry extends KeyBasedIntervalRegistry {


    @Value("${quota.host.intervalMs}")
    private long intervalDurationMs;

    @Value("${quota.host.ttlMs}")
    private long  ttlMs;

    @Value("${quota.host.whitelist}")
    private String whiteList;

    @Value("${quota.host.blacklist}")
    private String blackList;


    public HostRequestIntervalRegistry() {
        super(0,0,null,null,null);
    }
}
