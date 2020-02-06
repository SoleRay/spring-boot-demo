package bean.annotation.property.autowire;

import com.demo.Application;
import com.demo.bean.common.annotation.property.autowire.AnnBeanPropAutowire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TestAnnPropAutowire {

    @Autowired
    private AnnBeanPropAutowire annBeanPropAutowire;

    @Test
    public void test(){

//        System.out.println(annBeanPropAutowire.getAnnMap().get("plainBean"));
    }
}
