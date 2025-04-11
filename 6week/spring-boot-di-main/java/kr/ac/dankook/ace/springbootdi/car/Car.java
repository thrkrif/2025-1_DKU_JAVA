package kr.ac.dankook.ace.springbootdi.car;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class Car {
    private final Engine engine;
    private final Transmission transmission;
/*
    // constructor-based dependency injection
    @Autowired
    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }
*/
}
