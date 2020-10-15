package ioc.spring.inject;

import ioc.spring.dependecyLookUp.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

public class StudentRepository {

    private Collection<Student> students; //自定义bean

    private BeanFactory beanFactory;  //内建非bean 对象，（依赖）

    private ObjectFactory<Student> objectFactory;


    private ObjectFactory<ApplicationContext> objectFactoryApplication;

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<Student> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<Student> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactoryApplication() {
        return objectFactoryApplication;
    }

    public void setObjectFactoryApplication(ObjectFactory<ApplicationContext> objectFactoryApplication) {
        this.objectFactoryApplication = objectFactoryApplication;
    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "students=" + students +
                '}';
    }
}
