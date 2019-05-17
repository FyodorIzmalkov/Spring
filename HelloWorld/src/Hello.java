import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld obj = (HelloWorld) applicationContext.getBean("HelloWorld");
        obj.getMessage();
    }
}
