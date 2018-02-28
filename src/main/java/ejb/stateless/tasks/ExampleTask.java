package ejb.stateless.tasks;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.TimerTask;

@Stateless
public class ExampleTask extends TimerTask {

    @EJB
    private ejb.statefull.CounterBean counter;

    @Override
    public void run() {
        System.out.println("Counter is: " + counter.count());
    }
}