package ioc.spring.container;

import ioc.spring.dependecyLookUp.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class IocApplicationContextContainerAnnoDemo {

    public static void main(String[] args) {
          //创建applicationContext 容器(注解实现)
        AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext();
        //注册
        applicationContext.register(IocApplicationContextContainerAnnoDemo.class);
        //启动容器
        applicationContext.refresh();
        lookUpDependencyByType(applicationContext);
    }

    private static void lookUpDependencyByType(BeanFactory beanFactory) {

        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory beanFactory1 = (ListableBeanFactory) beanFactory;
            Map<String, Student> beansOfType = beanFactory1.getBeansOfType(Student.class);
            System.out.println(beansOfType);
        }
    }
    
    @Bean
    public Student student(){
        Student student = new Student();
        student.setId(1L);
        student.setNamel("测试name");
        return student;
    }

}
