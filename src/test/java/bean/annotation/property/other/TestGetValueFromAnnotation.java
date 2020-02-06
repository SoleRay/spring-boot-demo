package bean.annotation.property.other;

import com.demo.Application;
import com.demo.bean.common.annotation.property.autowire.AnnBeanPropAutowire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TestGetValueFromAnnotation {

    @Test
    public void getValue() {
        Field[] fields = AnnBeanPropAutowire.class.getDeclaredFields();
        for(Field field : fields){
            for(Annotation annotation : field.getDeclaredAnnotations()){
                Method[] annMethods = annotation.annotationType().getDeclaredMethods();
                for(Method annMethod : annMethods){
                    try {
                        Object value = annMethod.invoke(annotation);
                        System.out.println("Field:"+ field.getName() + "->" + annotation.annotationType().getSimpleName()+":"+value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }
}