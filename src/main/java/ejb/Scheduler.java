package ejb;

import ejb.statefull.CounterBean;
import ejb.util.ThreadExecutor;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.time.ZonedDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Startup
@Singleton
public class Scheduler {

    @EJB
    private CounterBean counter;

    @PostConstruct
    public void init() {
        ScheduledExecutorService scheduledExecutor = ThreadExecutor.getScheduledInstance();
        scheduledExecutor.scheduleWithFixedDelay(() -> System.out.println("Scheduled execution..."), 0, 5, TimeUnit.MINUTES);
    }

    @Schedule(second = "*/5", minute="*", hour="*")
    public void timeout1(Timer timer) {
        System.out.println("Counter is: " + counter.count());
    }

    @Schedule(second = "*/10", minute="*", hour="*")
    public void timeout2(Timer timer) {
        ExecutorService executorService = ThreadExecutor.getInstance();
        executorService.execute(() -> System.out.println("Runnable... without return value."));
        Future<ZonedDateTime> future = executorService.submit(() -> {
            System.out.println("Callable...with a return value.");
            return ZonedDateTime.now();
        });
    }
}