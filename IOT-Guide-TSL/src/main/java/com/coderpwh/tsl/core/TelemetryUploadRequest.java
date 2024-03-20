package com.coderpwh.tsl.core;

import com.coderpwh.tsl.data.kv.KvEntry;
import com.coderpwh.tsl.session.FromDeviceRequestMsg;
import java.util.List;
import java.util.Map;

/**
 * @author coderpwh
 */
public interface TelemetryUploadRequest extends FromDeviceRequestMsg {
    Map<Long, List<KvEntry>> getData();

}
