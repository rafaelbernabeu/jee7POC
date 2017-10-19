package ejb.stateless;

import javax.ejb.Stateless;

@Stateless
public class CalculatorBean {

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }
}
