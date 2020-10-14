package ioc.javaImpl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

public class BeansInfo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);
            //propertyDescriptor可以添加属性编辑器propertyEditor,
            //属性编辑器可以帮助吧String转成响应的类型（propertyType）
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            if("age".equals(propertyDescriptor.getName())){//为age时候为字段添加propertyEditor
                propertyDescriptor.setPropertyEditorClass(StringToInteger.class);
                propertyDescriptor.createPropertyEditor(new Person());
            }
        });
    }

    //在spring3.0之前把text转成响应的类型，大都基于PropertyEditorSupport实现
    static class StringToInteger extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer integer = Integer.valueOf(text);
            setValue(integer);

        }
    }
}
