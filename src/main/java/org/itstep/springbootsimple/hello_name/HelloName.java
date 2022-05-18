package org.itstep.springbootsimple.hello_name;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@PropertySource("classpath:words.properties") //Подключение файла properties
public class HelloName {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(HelloName.class, args);
    }

    @RestController
    static class HelloController {

        @Value("${app.hello}") //Переменная должна по умолчанию находиться в application.properties
        private String hello;

        @Value("${app.name}")
        private String name;

        @RequestMapping("/")
        public String index() {
            return String.format("%s, %s!%n", hello, name);
        }
    }
}