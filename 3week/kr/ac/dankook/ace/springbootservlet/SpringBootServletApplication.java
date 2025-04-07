package kr.ac.dankook.ace.springbootservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // servlet auto register
@SpringBootApplication
public class SpringBootServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServletApplication.class, args);
	}

}
