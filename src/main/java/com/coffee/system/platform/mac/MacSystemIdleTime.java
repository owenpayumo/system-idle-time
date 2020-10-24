package com.coffee.system.platform.mac;


import com.coffee.system.SystemIdleTime;


public class MacSystemIdleTime implements SystemIdleTime {
    @Override
    public long getSystemIdleTime() {
        return (long) (CoreGraphics.INSTANCE.CGEventSourceSecondsSinceLastEventType(CoreGraphics.kCGEventSourceStateHIDSystemState, CoreGraphics.kCGAnyInputEventType) * 1000);
    }
}