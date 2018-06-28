package ejb;

import ejb.stateless.tasks.ExampleTask;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import java.time.ZonedDateTime;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Startup
@Singleton
public class Scheduler {

    @EJB
    private ExampleTask task;
    
    @Resource(lookup = "java:comp/DefaultManagedScheduledExecutorService")
    private ManagedScheduledExecutorService scheduledExecutorService;

    @Resource(lookup = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;

    @PostConstruct
    public void init() {
        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("Scheduled execution..."), 1, 5, TimeUnit.SECONDS);
        executorService.execute(() -> System.out.println("Tasks started."));
    }

//    @Schedule(second = "*/5", minute="*", hour="*")
    public void timeout1(Timer timer) {
        task.run();
    }

//    @Schedule(second = "*/10", minute="*", hour="*")
    public void timeout2(Timer timer) {
        executorService.execute(() -> System.out.println("Runnable... without return value."));
        Future<ZonedDateTime> future = executorService.submit(() -> {
            System.out.println("Callable...with a return value.");
            return ZonedDateTime.now();
        });
    }
}
