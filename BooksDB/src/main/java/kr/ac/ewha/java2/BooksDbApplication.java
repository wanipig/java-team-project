package kr.ac.ewha.java2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("kr.ac.ewha.java2")
public class BooksDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksDbApplication.class, args);
		System.out.println("Library Application Start!");
	}

}
