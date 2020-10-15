package ioc.spring.inject;

import ioc.spring.dependecyLookUp.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 */
public class DenpendecyInjectMain {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");
        StudentRepository studentRepository = beanFactory.getBean("studentRepository", StudentRepository.class);
        System.out.println(studentRepository.getStudents());

        /**
         * DefaultListableBeanFactory
         * 依赖注入的beanfactory
         */
        System.out.println(studentRepository.getBeanFactory());
        System.out.println(studentRepository.getBeanFactory()==beanFactory);
        /**
         * 依赖查找的bean
         */
//        System.out.println(beanFactory.getBean(BeanFactory.class));


        /**
         * 依赖查找和依赖注入都是依赖，但是两个依赖来自同地方吗？？？
         */


        Student object = studentRepository.getObjectFactory().getObject();
        System.out.println("注入内建非bean对象"+object);

        ApplicationContext app = studentRepository.getObjectFactoryApplication().getObject();
        System.out.println(beanFactory==app);

    }
}
