package kr.ac.dankook.ace.springbootdi.coffee;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roast {
    private int degree;

    public void print() {
        switch (this.degree) {
        case 1 -> System.out.println("Degree of Roast: Light Roast");
        case 2 -> System.out.println("Degree of Roast: Medium Roast");
        case 3 -> System.out.println("Degree of Roast: Dark Roast");
        }
    }

}
