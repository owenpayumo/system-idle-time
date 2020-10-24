package com.coffee.system.platform.windows;

import com.coffee.system.SystemIdleTime;

public class WindowsSystemIdleTime implements SystemIdleTime {
    @Override
    public long getSystemIdleTime() {
        User32.LASTINPUTINFO lastInputInfo = new User32.LASTINPUTINFO();
        User32.INSTANCE.GetLastInputInfo(lastInputInfo);
        return Kernel32.INSTANCE.GetTickCount() - lastInputInfo.dwTime;
    }
}