package com.coderpwh.tsl.core;

import com.coderpwh.tsl.data.kv.KvEntry;
import com.coderpwh.tsl.session.SessionMsgType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author coderpwh
 */
public class BasicTelemetryUploadRequest  extends BasicRequest implements TelemetryUploadRequest  {


    private static final long serialVersionUID = 1L;

    private final Map<Long, List<KvEntry>> data;

    public BasicTelemetryUploadRequest() {
        this(DEFAULT_REQUEST_ID);
    }

    public BasicTelemetryUploadRequest(Integer requestId) {
        super(requestId);
        this.data = new HashMap<>();
    }

    public void add(long ts, KvEntry entry) {
        List<KvEntry> tsEntries = data.get(ts);
        if (tsEntries == null) {
            tsEntries = new ArrayList<>();
            data.put(ts, tsEntries);
        }
        tsEntries.add(entry);
    }

    @Override
    public SessionMsgType getMsgType() {
        return SessionMsgType.POST_TELEMETRY_REQUEST;
    }

    @Override
    public Map<Long, List<KvEntry>> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BasicTelemetryUploadRequest [dao=" + data + "]";
    }

    @Override
    public Integer getRquestId() {
        return null;
    }
}
