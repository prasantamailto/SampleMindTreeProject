package net.MindTree.spring.boot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author prasa
 *
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	
}
