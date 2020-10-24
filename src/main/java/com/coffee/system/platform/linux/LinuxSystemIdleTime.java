package com.coffee.system.platform.linux;

import com.coffee.system.SystemIdleTime;
import com.sun.jna.platform.unix.X11;

import java.util.concurrent.TimeUnit;

public class LinuxSystemIdleTime implements SystemIdleTime {

    @Override
    public long getSystemIdleTime() {
        X11.Window window = null;
        Xss.XScreenSaverInfo xScreenSaverInfo = null;
        X11.Display display = null;
        final X11 x11 = X11.INSTANCE;
        final Xss xss = Xss.INSTANCE;

        long millis = 0L;
        try {
            display = x11.XOpenDisplay(null);
            window = x11.XDefaultRootWindow(display);
            xScreenSaverInfo = xss.XScreenSaverAllocInfo();
            xss.XScreenSaverQueryInfo(display, window, xScreenSaverInfo);

            millis = xScreenSaverInfo.idle.longValue();
        } finally {
            if (xScreenSaverInfo != null)
                x11.XFree(xScreenSaverInfo.getPointer());
            xScreenSaverInfo = null;

            if (display != null)
                x11.XCloseDisplay(display);
            display = null;
        }
        return millis;
    }
}
