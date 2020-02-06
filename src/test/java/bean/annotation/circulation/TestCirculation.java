package bean.annotation.circulation;

import com.demo.Application;
import com.demo.bean.common.annotation.circulation.AnnX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TestCirculation {

    @Autowired
    private AnnX annX;

    @Test
    public void test(){

    }
}
