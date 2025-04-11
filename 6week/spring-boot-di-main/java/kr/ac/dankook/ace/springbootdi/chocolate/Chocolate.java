package kr.ac.dankook.ace.springbootdi.chocolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chocolate {
    // field-based dependency injection (cannot use final) 
    @Autowired
    private Brand brand;
    // field-based dependency injection (cannot use final) 
    @Autowired
    private Type type;
}
