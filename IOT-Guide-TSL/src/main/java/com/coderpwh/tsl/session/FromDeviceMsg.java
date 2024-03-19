package com.coderpwh.tsl.session;

import java.io.Serializable;

/**
 * @author coderpwh
 */
public interface FromDeviceMsg  extends Serializable {

    SessionMsgType getMsgType();

}
