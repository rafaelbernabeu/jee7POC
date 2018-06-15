package ejb.stateless.tasks;

import ejb.statefull.CounterBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.TimerTask;

@Stateless
public class ExampleTask extends TimerTask {

    @EJB
    private CounterBean counter;

    @Override
    public void run() {
        System.out.println("Counter is: " + counter.count());
    }
}