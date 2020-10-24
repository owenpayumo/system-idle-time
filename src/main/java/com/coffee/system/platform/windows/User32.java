package com.coffee.system.platform.windows;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;

import java.util.Arrays;
import java.util.List;

public interface User32  extends StdCallLibrary {
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
    boolean GetLastInputInfo(User32.LASTINPUTINFO result);
}