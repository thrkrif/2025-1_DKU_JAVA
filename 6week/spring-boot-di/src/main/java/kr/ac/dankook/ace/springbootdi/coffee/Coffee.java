package kr.ac.dankook.ace.springbootdi.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Coffee {
    private Origin origin;
    private Roast roast;

    // setter-based dependency injection
    @Autowired
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    // setter-based dependency injection
    @Autowired
    public void setRoast(Roast roast) {
        this.roast = roast;
    }

    public void print() {
        this.origin.print();
        this.roast.print();
    }
}
