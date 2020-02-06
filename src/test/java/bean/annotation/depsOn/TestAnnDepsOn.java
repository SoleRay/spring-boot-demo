package bean.annotation.depsOn;

import com.demo.Application;
import com.demo.bean.common.annotation.depsOn.AnnBeanDepOn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TestAnnDepsOn {

    @Autowired
    private AnnBeanDepOn annBeanDepOn;

    @Test
    public void test(){
        System.out.println(annBeanDepOn);
    }
}
