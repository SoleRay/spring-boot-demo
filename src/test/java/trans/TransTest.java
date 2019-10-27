package trans;

import com.demo.Application;
import com.demo.entity.demo.Demo;
import com.demo.service.bus.BusService;
import com.demo.service.demo.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TransTest {

    @Autowired
    private BusService busService;

    @Autowired
    private DemoService demoService;

    @Test
    public void addDemo(){
        Demo d = new Demo();
        d.setDemoKey("color");
        d.setDemoName("green");
        demoService.insert(d);
    }

    @Test
    public void testDemo(){
        busService.doBusinsess();
    }

    @Test
    public void testDemo2(){
        busService.doBusinsess2();
    }

    @Test
    public void testDemo3(){
        busService.doBusinsess3();
    }
}
