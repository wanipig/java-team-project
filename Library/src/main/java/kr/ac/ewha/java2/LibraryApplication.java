package kr.ac.ewha.java2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Spring Boot 애플리케이션의 주요 진입점 명시
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		System.out.println("Library Application Start!");
	}

}
