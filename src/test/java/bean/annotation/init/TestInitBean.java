package bean.annotation.init;

import com.demo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TestInitBean {

    @Autowired
//    private InitBean initBean;

    @Test
    public void test(){
//        System.out.println(initBean);
    }
}
