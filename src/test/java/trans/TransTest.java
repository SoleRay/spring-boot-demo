package trans;

import com.demo.Application;
import com.demo.entity.demo.Demo;
import com.demo.service.bus.BusService;
import com.demo.service.demo.DemoService;
import com.demo.service.tx.TxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TransTest {

    @Autowired
    private BusService busService;

    @Autowired
    private TxService txService;

    @Test
    public void addDemo(){
        Demo demo = new Demo();
        txService.add(demo);
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
