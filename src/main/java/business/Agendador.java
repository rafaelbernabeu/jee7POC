package business;

import javax.annotation.PostConstruct;
import javax.ejb.*;

@Singleton
@Startup
public class Agendador {

    @Schedule(second = "*/1",minute="*", hour="*")
    public void timeout(Timer timer) {
        System.out.println("TimerBean: timeout occurred");
    }

    @PostConstruct
    public void teste() { System.out.println("Teste"); }

}
