package com.coderpwh.tsl.core;

import com.coderpwh.tsl.data.kv.AttributeKvEntry;
import com.coderpwh.tsl.session.FromDeviceRequestMsg;

import java.util.Set;

/**
 * @author coderpwh
 */
public interface AttributesUpdateRequest extends FromDeviceRequestMsg {

    Set<AttributeKvEntry> getAttributes();

}
