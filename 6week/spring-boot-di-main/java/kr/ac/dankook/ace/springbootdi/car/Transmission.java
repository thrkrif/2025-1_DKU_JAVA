package kr.ac.dankook.ace.springbootdi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data // @Getter, @Setter, @ToString
public class Transmission {
    private final String name;

    // DI using Constructor
    @Autowired
    public Transmission(String name) {
        this.name = name;
    }

}
