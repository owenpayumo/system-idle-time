package com.coffee.platform;

import com.sun.jna.Platform;
import com.coffee.platform.linux.LinuxIdleTimeUtils;
import com.coffee.platform.mac.MacIdleTimeUtils;
import com.coffee.platform.win.WinIdleTimeUtils;

public abstract class IdleTimeUtils {
    public abstract long getIdleTimeMillis();

    private volatile static IdleTimeUtils instance;
    public synchronized static IdleTimeUtils getInstance() {
        if (instance == null) {
            if (Platform.isMac())
                instance = new MacIdleTimeUtils();
            else if (Platform.isWindows())
                instance = new WinIdleTimeUtils();
            else
                instance = new LinuxIdleTimeUtils();
        }
        return instance;
    }

}