package ejb.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadExecutor {

    private static ExecutorService executor;
    private static ScheduledExecutorService scheduledExecutor;

    public static ExecutorService getInstance() {
        if (executor == null) {
            synchronized (ThreadExecutor.class) {
                if (executor == null) {
                    executor = Executors.newCachedThreadPool();
                }
            }
        }
        return executor;
    }

    public static ScheduledExecutorService getScheduledInstance() {
        if (scheduledExecutor == null) {
            synchronized (ThreadExecutor.class) {
                if (scheduledExecutor == null) {
                    scheduledExecutor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
                }
            }
        }
        return scheduledExecutor;
    }

}
