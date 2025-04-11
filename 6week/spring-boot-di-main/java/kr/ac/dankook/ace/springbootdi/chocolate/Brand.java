package kr.ac.dankook.ace.springbootdi.chocolate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private String name;
    private String country;
}
