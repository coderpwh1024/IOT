package com.coderpwh.tsl.core;

import com.coderpwh.tsl.data.kv.AttributeKvEntry;
import com.coderpwh.tsl.session.SessionMsgType;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author coderpwh
 */
public class BasicAttributesUpdateRequest extends BasicRequest implements AttributesUpdateRequest {

    private static final long serialVersionUID = 1L;

    private final Set<AttributeKvEntry> data;

    public BasicAttributesUpdateRequest() {
        this(DEFAULT_REQUEST_ID);
    }

    public BasicAttributesUpdateRequest(Integer requestId) {
        super(requestId);
        this.data = new LinkedHashSet<>();
    }

    public BasicAttributesUpdateRequest(Integer requestId, Set<AttributeKvEntry> data) {
        super(requestId);
        this.data = data;
    }

    public void add(AttributeKvEntry entry) {
        this.data.add(entry);
    }

    public void add(Collection<AttributeKvEntry> entries) {
        this.data.addAll(entries);
    }

    @Override
    public SessionMsgType getMsgType() {
        return SessionMsgType.POST_ATTRIBUTES_REQUEST;
    }

    @Override
    public Set<AttributeKvEntry> getAttributes() {
        return data;
    }

    @Override
    public String toString() {
        return "BasicAttributesUpdateRequest [dao=" + data + "]";
    }

    @Override
    public Integer getRquestId() {
        return null;
    }
}
