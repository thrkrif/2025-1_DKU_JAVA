package kr.ac.dankook.ace.springbootdi.car3;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data // @Getter, @Setter, @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Engine3 {
    private String name;
    private int power;
}
