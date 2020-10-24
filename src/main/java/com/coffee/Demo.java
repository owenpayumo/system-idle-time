package com.coffee;

import com.coffee.system.SystemIdleTime;
import com.coffee.system.platform.linux.LinuxSystemIdleTime;
import com.coffee.system.platform.mac.MacSystemIdleTime;
import com.coffee.system.platform.windows.WindowsSystemIdleTime;
import com.sun.jna.Platform;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    static Logger log = LoggerFactory.getLogger(Demo.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SystemIdleTime systemIdleTime = null;
        if (Platform.isMac()) systemIdleTime = new MacSystemIdleTime();
        else if (Platform.isWindows()) systemIdleTime = new WindowsSystemIdleTime();
        else if (Platform.isLinux()) systemIdleTime = new LinuxSystemIdleTime();

        if (systemIdleTime == null) throw new RuntimeException("Not supported");

        while (true) {
            log.info("idle time: {}", systemIdleTime.getSystemIdleTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
