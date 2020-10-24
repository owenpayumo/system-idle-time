package com.coffee.platform.win;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;
import com.coffee.platform.IdleTimeUtils;

import java.util.Arrays;
import java.util.List;

public class WinIdleTimeUtils extends IdleTimeUtils {
    public static interface Kernel32 extends StdCallLibrary {
        Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
        public int GetTickCount();
    }
    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32)Native.loadLibrary("user32", User32.class);
        public static class LASTINPUTINFO extends Structure {
            public int cbSize = 8;
            /// Tick count of when the last input event was received.
            public int dwTime;

            @SuppressWarnings("rawtypes")
            @Override
            protected List getFieldOrder() {
                return Arrays.asList(new String[] { "cbSize", "dwTime" });
            }
        }
        public boolean GetLastInputInfo(LASTINPUTINFO result);
    }

    public long getIdleTimeMillis() {
        User32.LASTINPUTINFO lastInputInfo = new User32.LASTINPUTINFO();
        User32.INSTANCE.GetLastInputInfo(lastInputInfo);
        return Kernel32.INSTANCE.GetTickCount() - lastInputInfo.dwTime;
    }
}