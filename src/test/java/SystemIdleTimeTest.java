import com.coffee.SystemIdleTime;
import org.junit.Assert;
import org.junit.Test;

public class SystemIdleTimeTest {

    @Test
    public void testGetSystemIdleTime() throws InterruptedException {
        SystemIdleTime systemIdleTime = new SystemIdleTime();
        Thread.sleep(5000);
        long result = systemIdleTime.getSystemIdleTime();
        Assert.assertTrue(String.format("Expected result should be greater than 0 Actual result is %s", result), 0 < systemIdleTime.getSystemIdleTime());
    }
}
