package kr.ac.dankook.ace.springbootdi.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository // Spring component
@Data
public class LoginUserRepository {
    private List<LoginUser> userList;

    public void printList() {
        System.out.println("LoginUserRepository printList userList=" + this.userList);
    }
}
