package ejb.statefull;

import javax.ejb.Stateful;

@Stateful
public class CounterBean {

    private Integer counter = 0;

    public Integer count() {
        return counter++;
    }
}