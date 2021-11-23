package com.revature.p1;

import com.revature.p1.config.BeanConfig;
import com.revature.p1.config.WebConfig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@RestController
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext();
        spring.register(BeanConfig.class);

        Tomcat server = new Tomcat();
        server.setPort(8081);
        server.getConnector();
        server.addContext("", null);

        AnnotationConfigWebApplicationContext springmvc = new AnnotationConfigWebApplicationContext();
        springmvc.scan("com.revature.p1");
        server.addServlet("", "dispatcher", new DispatcherServlet(springmvc)).addMapping("/");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
