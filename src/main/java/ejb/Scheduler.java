package ejb;

import ejb.statefull.CounterBean;
import ejb.stateless.CalculatorBean;

import javax.annotation.PostConstruct;
import javax.ejb.*;

@Startup
@Singleton
public class Scheduler {

    @EJB
    private CalculatorBean calculator;

    @EJB
    private CounterBean counter;

    @PostConstruct
    public void init() { System.out.println("EJB Created!"); }

    @Schedule(second = "*/1", minute="*", hour="*")
    public void timeout1(Timer timer) {
        System.out.println("Sum is: " + calculator.sum(1,1));
        System.out.println("Counter is: " + counter.count());
    }
}