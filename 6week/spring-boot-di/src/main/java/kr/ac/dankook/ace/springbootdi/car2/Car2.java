package kr.ac.dankook.ace.springbootdi.car2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Car2 {
    private Engine2 engine;
    private Transmission2 transmission;

    // setter-based dependency injection
    @Autowired
    public void setEngine(Engine2 engine) {
        this.engine = engine;
    }

    // setter-based dependency injection
    @Autowired
    public void setTransmission(Transmission2 transmission) {
        this.transmission = transmission;
    }
}
