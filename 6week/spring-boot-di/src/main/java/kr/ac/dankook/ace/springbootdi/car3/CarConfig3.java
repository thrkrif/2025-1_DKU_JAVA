package kr.ac.dankook.ace.springbootdi.car3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig3 {
    // Configuring Engine for Car
    @Bean
    public Engine3 engine3() {
        return new Engine3("VR6", 6); 
    }

    // Configuring Transmission for Car
    @Bean
    public Transmission3 transmission3() {
        return new Transmission3("Dual Clutch"); 
    }
}
