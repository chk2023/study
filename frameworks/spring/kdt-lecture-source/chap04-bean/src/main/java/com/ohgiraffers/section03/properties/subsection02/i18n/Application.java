package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404MessageKR
                = applicationContext.getMessage("error.404", null, Locale.KOREA);
        String error500MessageKR
                = applicationContext.getMessage("error.500", new Object[]{"여러분", new Date()}, Locale.KOREA);

        System.out.println("error404MessageKR = " + error404MessageKR);
        System.out.println("error500MessageKR = " + error500MessageKR);

        String error404MessageUS
                = applicationContext.getMessage("error.404", null, Locale.US);
        String error500MessageUS
                = applicationContext.getMessage("error.500", new Object[]{"you", new Date()}, Locale.US);

        System.out.println("error404MessageUS = " + error404MessageUS);
        System.out.println("error500MessageUS = " + error500MessageUS);
    }
}
