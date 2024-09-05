import NYH.ex01.conf.MyConf1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                =new AnnotationConfigApplicationContext(MyConf1.class);

        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(System.out::println);
    }
}
