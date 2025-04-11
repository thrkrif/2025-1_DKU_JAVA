package kr.ac.dankook.ace.springbootdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.dankook.ace.springbootdi.car.Car;
import kr.ac.dankook.ace.springbootdi.chocolate.ChocolateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/di")
public class SpringBootDiController {
    @Autowired
    Car car;
    @Autowired
    ChocolateRepository chocolateRepository;
    
    @GetMapping("/car")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
