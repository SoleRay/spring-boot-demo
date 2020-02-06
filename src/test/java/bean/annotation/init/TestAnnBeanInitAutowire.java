package bean.annotation.init;

import com.demo.Application;
import com.demo.bean.common.annotation.init.AnnBeanInitAutowire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TestAnnBeanInitAutowire {

    @Autowired
    private AnnBeanInitAutowire annBeanInitAutowire;

    @Test
    public void test(){
        annBeanInitAutowire.getBeanName();
//        System.out.println(annBeanPropAutowire.getAnnMap().get("plainBean"));
    }
}
