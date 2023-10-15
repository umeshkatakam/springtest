 
package com.root;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages= {"com.example"})
@ComponentScan("com.example")
public class SpringtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtestApplication.class, args);
	}


    @Autowired
    private Environment	 environment;

    public void run(String... args) throws Exception {

        System.out.println("Active profiles: " +
                Arrays.toString(environment.getActiveProfiles()));
    }
}

@Component
@Profile(value="dev")
class MyRunner2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In development");
    }
}

@Component
@Profile(value="prod & !dev")
class MyRunner3 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In production");
    }
}

@Component
@Profile(value="local")
class MyRunner4 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In local");
    }
}

@Component
@Profile(value={"dev & local"})
class MyRunner5 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In development and local");
    }
}

@Component
@Profile(value={"dev", "prod"})
class MyRunner6 implements CommandLineRunner {

    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Message: " + message);
    }
} 
