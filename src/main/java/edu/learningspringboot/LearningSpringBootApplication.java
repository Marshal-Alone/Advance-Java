package edu.learningspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringBootApplication {
    //http://localhost:8080/swagger-ui/index.html


    public static void main(String[] args) {
        SpringApplication.run(LearningSpringBootApplication.class, args);
        System.out.println("\n=========== Server Started ===========\n");
    }

}
