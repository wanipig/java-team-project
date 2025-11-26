package kr.ac.ewha.java2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.ac.ewha.java2.create.service.BookCreateService;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	private BookCreateService bookCreateService;
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		System.out.println("Library Application Start!");
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Library Application is running...");
	}
	
	

}
