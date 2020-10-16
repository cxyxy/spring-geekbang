package ioc.spring.container;

import ioc.spring.dependecyLookUp.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class IocBeanFactoryContainerDemo {

    public static void main(String[] args) {
        //创建beanfactiory 容器,
        //DefaultListableBeanFactory 是beanfactory 的一个实现。
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String lcoation = "classpath:/META-INF/dependency-lookUp-context.xml";
        //加载xml
        int i = xmlBeanDefinitionReader.loadBeanDefinitions(lcoation);
        System.out.println("获取xml中定义的bean 的num="+i);

        lookUpDependencyByType(defaultListableBeanFactory);
    }

    private static void lookUpDependencyByType(BeanFactory beanFactory) {

        if(beanFactory instanceof DefaultListableBeanFactory){
            ListableBeanFactory beanFactory1 = (ListableBeanFactory) beanFactory;
            Map<String, Student> beansOfType = beanFactory1.getBeansOfType(Student.class);
            System.out.println(beansOfType);
        }
    }


}
