package com.lorelib.accesscontrol.infrastructure.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by listening on 2017/3/28.
 */
public class LoggerUtil {
    public Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
