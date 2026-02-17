package org.Hibernate_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.Hibernate_spring.config.AppConfig;
import org.Hibernate_spring.service.UserService;
import org.Hibernate_spring.entity.User;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService service = context.getBean(UserService.class);
        service.createUser("Ishank");
        service.createUser("Rahul");

        service.getUsers().forEach(u -> {
            User user = (User) u;
            System.out.println("User: " + user.getName());
        });
        context.close();
    }
}