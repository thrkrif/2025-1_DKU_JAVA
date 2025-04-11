package kr.ac.dankook.ace.springbootdi.car3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car3 {
    // field-based dependency injection (cannot use final) 
    @Autowired
    private Engine3 engine;
    // field-based dependency injection (cannot use final) 
    @Autowired
    private Transmission3 transmission;
}
