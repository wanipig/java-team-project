package kr.ac.ewha.java2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("kr.ac.ewha.java2")
public class BooksDb1Application {

	public static void main(String[] args) {
		SpringApplication.run(BooksDb1Application.class, args);
	}

}   
