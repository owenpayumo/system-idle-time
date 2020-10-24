package com.coffee.system.platform.windows;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32  extends StdCallLibrary {
    Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class);
    int GetTickCount();
}