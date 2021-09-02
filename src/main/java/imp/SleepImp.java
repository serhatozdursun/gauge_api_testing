package imp;

import com.thoughtworks.gauge.Step;

public class SleepImp {

    @Step("Sleep for <second> second")
    public void sleepForSecond(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }

    @Step("Sleep for <second> milliSecond")
    public void sleepForMillisecond(int millisecond) throws InterruptedException {
        Thread.sleep(millisecond);
    }
}
