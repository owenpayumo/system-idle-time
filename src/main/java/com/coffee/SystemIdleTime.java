package com.coffee;

import com.coffee.platform.IdleTimeUtils;

import java.util.concurrent.TimeUnit;

public class SystemIdleTime {
    private IdleTimeUtils idleTimeUtils;

    public SystemIdleTime() {
        idleTimeUtils = IdleTimeUtils.getInstance();
    }

    public long getSystemIdleTime() {
        if (idleTimeUtils != null) return TimeUnit.MILLISECONDS.toSeconds(idleTimeUtils.getIdleTimeMillis());
        return 0;
    }
}
