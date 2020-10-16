package ioc.spring.dependecyLookUp;

        import org.springframework.beans.factory.BeanFactory;
        import org.springframework.beans.factory.ListableBeanFactory;
        import org.springframework.beans.factory.ObjectFactory;
        import org.springframework.context.support .ClassPathXmlApplicationContext;

        import java.util.Map;

/**
 * 依赖查找
 */
public class LookUpdenpendecyLookUpMain {

    public static void main(String[] args) {
        /**
         * beanFactory\factoryBean\objectFactory 区别
         * ObjectFactory 通常是针对单类 Bean 做延迟获取的，BeanFactory 则是全局 Bean 管理的容器。
         */
        //配置xml+启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookUp-context.xml");
        /**
         * 实时查找
         */
//        Student testStudent = beanFactory.getBean("testStudent", Student.class);
//        lookUpInLazy(beanFactory);
//        lookUpInRealTime(beanFactory);
//        lookUpInType(beanFactory);
        lookUpCollectionByType(beanFactory);
        lookUpCollectionByAnno(beanFactory);
    }

    /**
     * 根据注解查找
     * @param beanFactory
     */
    private static void lookUpCollectionByAnno(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            //map的key是bean的id,value 是对象
            Map<String, Student> beansOfType = (Map)listableBeanFactory.getBeansWithAnnotation(Supper.class);
            System.out.println("实时查找，注解查找的student"+beansOfType);

        }
    }

    /**
     * 根据类查找集合类型对象
     * @param beanFactory
     */
    private static void lookUpCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            //map的key是bean的id,value 是对象
            Map<String, Student> beansOfType = listableBeanFactory.getBeansOfType(Student.class);
            System.out.println("实时查找，查找所有类型的student"+beansOfType);

        }
    }

    /**
     * 根据类型实时查找
     * @param beanFactory
     */
    private static void lookUpInType(BeanFactory beanFactory) {
        Student testStudent = beanFactory.getBean(Student.class);
        System.out.println("实时"+testStudent);
    }

    /**
     * 延迟查找
     * @param beanFactory
     * @return
     *
     *
     *
     *  ObjectFactory 对象并不是直接返回了实际的 Bean，而是一个 Bean 的查找代理。
     *  当得到 ObjectFactory 对象时，相当于 Bean 没有被创建，只有当 getObject() 方法时，才会触发 Bean 实例化等生命周期
     */
    private static Student lookUpInLazy(BeanFactory beanFactory){
        /***
         * objectFactory是不是没有生成新的对象
         *
         * 和factoryBean区别？？？？？？
         */
        ObjectFactory<Student> objectFactory = (ObjectFactory<Student>) beanFactory.getBean("objectFactory");
        Student object = objectFactory.getObject();
        System.out.println("延迟"+object);
        return object;
    }

    /**
     * 实时查找
     * @param beanFactory
     * @return
     */
    private static Student lookUpInRealTime(BeanFactory beanFactory){
        Student testStudent = beanFactory.getBean("testStudent", Student.class);
        System.out.println("实时"+testStudent);
        return testStudent;
    }
}
