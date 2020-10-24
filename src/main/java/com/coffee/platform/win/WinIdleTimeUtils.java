package com.coffee.platform.win;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;
import com.coffee.platform.IdleTimeUtils;

import java.util.Arrays;
import java.util.List;

public class WinIdleTimeUtils extends IdleTimeUtils {
    public interface Kernel32 extends StdCallLibrary {
        Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class);
        int GetTickCount();
    }
    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = Native.load("user32", User32.class);
        class LASTINPUTINFO extends Structure {
            public int cbSize = 8;
            public int dwTime;

            @SuppressWarnings("rawtypes")
            @Override
            protected List getFieldOrder() {
                return Arrays.asList("cbSize", "dwTime");
            }
        }
        boolean GetLastInputInfo(LASTINPUTINFO result);
    }

    public long getIdleTimeMillis() {
        User32.LASTINPUTINFO lastInputInfo = new User32.LASTINPUTINFO();
        User32.INSTANCE.GetLastInputInfo(lastInputInfo);
        return Kernel32.INSTANCE.GetTickCount() - lastInputInfo.dwTime;
    }
}