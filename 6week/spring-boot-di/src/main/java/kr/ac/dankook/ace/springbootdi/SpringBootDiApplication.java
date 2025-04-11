package kr.ac.dankook.ace.springbootdi;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kr.ac.dankook.ace.springbootdi.car.Car;
import kr.ac.dankook.ace.springbootdi.chocolate.Brand;
import kr.ac.dankook.ace.springbootdi.chocolate.Chocolate;
import kr.ac.dankook.ace.springbootdi.chocolate.Type;

@SpringBootApplication
public class SpringBootDiApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run
		(SpringBootDiApplication.class, args);

		Car car = (appContext).getBean(Car.class);
		System.out.println("Car (생성자 DI): " + car);
		
	}

	@Bean
	public Chocolate chocolate(){
		return new Chocolate(new Brand("Chana", "South Korea")
		,new Type("Milk Chocholate"));
	}

	

}
