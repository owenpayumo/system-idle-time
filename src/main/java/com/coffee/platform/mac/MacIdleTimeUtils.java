package com.coffee.platform.mac;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.coffee.platform.IdleTimeUtils;


public class MacIdleTimeUtils extends IdleTimeUtils {
    public final int kCGAnyInputEventType = ~0;
    public final int kCGEventSourceStatePrivate = -1;
    public final int kCGEventSourceStateCombinedSessionState = 0;
    public final int kCGEventSourceStateHIDSystemState = 1;

    public interface CoreGraphics extends Library {
        CoreGraphics INSTANCE = (CoreGraphics) Native.loadLibrary("CoreGraphics", CoreGraphics.class);

        public double CGEventSourceSecondsSinceLastEventType(int source, int eventType);
    }

    public long getIdleTimeMillis() {
        return (long)(CoreGraphics.INSTANCE.CGEventSourceSecondsSinceLastEventType(kCGEventSourceStateHIDSystemState, kCGAnyInputEventType) * 1000);
    }
}