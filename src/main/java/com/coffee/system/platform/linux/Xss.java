package com.coffee.system.platform.linux;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Structure;
import com.sun.jna.platform.unix.X11;

import java.util.Arrays;
import java.util.List;

public interface Xss extends Library {
    Xss INSTANCE = Native.load("Xss", Xss.class);

    class XScreenSaverInfo extends Structure {
        public X11.Window window;
        public int state;
        public int kind;
        public NativeLong til_or_since;
        public NativeLong idle;
        public NativeLong event_mask;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("window", "state", "kind", "til_or_since",
                    "idle", "event_mask");
        }
    }

    Xss.XScreenSaverInfo XScreenSaverAllocInfo();

    int XScreenSaverQueryInfo(X11.Display display, X11.Drawable drawable, Xss.XScreenSaverInfo xScreenSaverInfo);
}