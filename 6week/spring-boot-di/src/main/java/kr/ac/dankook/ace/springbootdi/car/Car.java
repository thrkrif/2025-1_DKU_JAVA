package kr.ac.dankook.ace.springbootdi.car;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor // 이거 쓰세요 생성자 작성하는 부분 생략 가능하다.
public class Car {
    private final Engine engine;
    private final Transmission transmission;
/* 이거 굳이 쓰지말고
    // constructor-based dependency injection
    @Autowired
    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }
*/
}
