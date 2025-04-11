package kr.ac.dankook.ace.springbootdi.car2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig2 {
    // Configuring Engine2 for Car2
    @Bean
    public Engine2 engine2() {
        return new Engine2("v5", 3); 
    }

    // Configuring Transmission2 for Car2
    @Bean
    public Transmission2 transmission2() {
        return new Transmission2("automatic");
    }

    // Configuring car2 with engine2 & transmission2
    @Bean
    public Car2 car2() {
        Car2 car2 = new Car2();
		car2.setEngine(engine2()); // setter DI
		car2.setTransmission(transmission2()); // setter DI
        return car2;
    }
}
