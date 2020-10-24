import com.coffee.system.SystemIdleTime;
import com.coffee.system.platform.linux.LinuxSystemIdleTime;
import com.coffee.system.platform.mac.MacSystemIdleTime;
import com.coffee.system.platform.windows.WindowsSystemIdleTime;
import com.sun.jna.Platform;
import org.junit.Assert;
import org.junit.Test;

public class SystemIdleTimeTest {

    @Test
    public void testGetSystemIdleTime() throws InterruptedException {
        SystemIdleTime systemIdleTime = null;
        if (Platform.isMac()) systemIdleTime = new MacSystemIdleTime();
        else if (Platform.isWindows()) systemIdleTime = new WindowsSystemIdleTime();
        else if (Platform.isLinux()) systemIdleTime = new LinuxSystemIdleTime();

        if (systemIdleTime == null) Assert.fail("Not supported");

        Thread.sleep(5000);
        long result = systemIdleTime.getSystemIdleTime();
        Assert.assertTrue(String.format("Expected result should be greater than 0 Actual result is %s", result), 0 < systemIdleTime.getSystemIdleTime());
    }
}
