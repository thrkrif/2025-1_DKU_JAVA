package kr.ac.dankook.ace.springbootdi.coffee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeConfig {    
    // Configuring origin for Coffee 
    @Bean
    public Origin origin() {
        return new Origin("Costa Rica");
    }

    // Configuring roast for Coffee 
    @Bean
    public Roast roast() {
        return new Roast(2);
    }

    // Configuring coffee with origin & roast
    @Bean
    public Coffee coffee() {
        Coffee coffee = new Coffee();
		coffee.setOrigin(origin()); // setter DI
		coffee.setRoast(roast()); // setter DI
        return coffee;
    }
}
