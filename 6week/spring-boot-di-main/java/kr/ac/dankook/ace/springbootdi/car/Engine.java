package kr.ac.dankook.ace.springbootdi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data // @Getter, @Setter, @ToString
public class Engine {
    private final String name;
    private final int power;

    // DI using Contructor
    @Autowired
    public Engine(String name, int power) {
        this.name = name;
        this.power = power;
    }

}
