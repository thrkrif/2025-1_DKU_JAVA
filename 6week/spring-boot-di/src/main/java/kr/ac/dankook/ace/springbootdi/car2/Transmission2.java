package kr.ac.dankook.ace.springbootdi.car2;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data // @Getter, @Setter, @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Transmission2 {
    private String name;
}
