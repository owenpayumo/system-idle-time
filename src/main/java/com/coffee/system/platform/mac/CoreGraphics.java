package com.coffee.system.platform.mac;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CoreGraphics extends Library {
    CoreGraphics INSTANCE = Native.load("CoreGraphics", CoreGraphics.class);
    int kCGAnyInputEventType = ~0;
    int kCGEventSourceStateHIDSystemState = 1;
    double CGEventSourceSecondsSinceLastEventType(int source, int eventType);
}