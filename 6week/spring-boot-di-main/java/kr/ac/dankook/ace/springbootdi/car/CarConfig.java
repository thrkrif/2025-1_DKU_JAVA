package kr.ac.dankook.ace.springbootdi.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {
    // Configuring Engine for Car
    @Bean
    public Engine engine() {
        return new Engine("v8", 5); // constructor DI
    }

    // Configuring Transmission for Car
    @Bean
    public Transmission transmission() {
        return new Transmission("sliding"); // constructor DI
    }
}
