package org.itstep.springbootsimple.animals;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

/*SpringBootApplication включает:
Configuration, EnableAutoConfiguration, ComponentScan
 */

//Без ComponentScan Component не делает ничего
@ComponentScan
public class ComponentScanDemo {
    private static ApplicationContext applicationContext;

    private class ExampleBean{}

    @Bean
    public ExampleBean getExampleBean(){
        return new ExampleBean();
    }

    public static void main(String[] args) {
        //Вывести все экземпляры бинов
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanDemo.class);
        for (String beanName:applicationContext.getBeanDefinitionNames())
            System.out.println(beanName);

        //Вызвать метод бина
        applicationContext.getBean(Dog.class).sound();

        //Содержит ли контекст приложения указанный бин
        System.out.println("Context contains bean cat: "+ applicationContext.containsBean("cat"));
         //Версия Spring
        System.out.println("Spring version: "+SpringVersion.getVersion());
        //Версия Hibernate
        System.out.println("Hibernate version: "+org.hibernate.Version.getVersionString());
        //Версия Java
        System.out.println("Java version: "+System.getProperty("java.version"));

    }
}
