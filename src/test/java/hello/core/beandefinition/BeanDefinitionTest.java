package hello.core.beandefinition;
import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //자바 코드를 읽어서 BeanDefinition을 등록하는 방법
    //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    //XML을 읽어서 BeanDefinition을 등록하는 방법
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        //name을 모두 뽑아서 배열에 담음
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //향상된 for문
        for (String beanDefinitionName : beanDefinitionNames) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName" + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}