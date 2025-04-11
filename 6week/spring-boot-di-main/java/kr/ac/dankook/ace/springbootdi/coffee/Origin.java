package kr.ac.dankook.ace.springbootdi.coffee;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Origin {
    private String source;

    public void print() {
        System.out.println("Source of origin: " + this.source);
    }
}
