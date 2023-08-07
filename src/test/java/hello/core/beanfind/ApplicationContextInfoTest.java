package hello.core.beanfind;

import hello.core.AppConfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        //alt + enter
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter + tab 하면 for문 자동완성
        for (String beanDefinitionName : beanDefinitionNames) {
            //alt + enter 하면 object가 나옴 -> 타입을 지정하지 않았기 때문에
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("Name = " + beanDefinitionName + " object = " + bean);
        }
    }
}
