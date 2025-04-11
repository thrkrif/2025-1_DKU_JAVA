package kr.ac.dankook.ace.springbootdi.user;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component // Spring component
@Data // @Getter, @Setter, @ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    private String loginId;
    private int password;
}
