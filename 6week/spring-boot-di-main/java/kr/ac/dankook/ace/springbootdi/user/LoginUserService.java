package kr.ac.dankook.ace.springbootdi.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@Data
public class LoginUserService {
    private LoginUserRepository userRepository;

    // setter-based dependency injection
    @Autowired
    public void setUserRepository(LoginUserRepository userRepository) {
        this.userRepository = userRepository;
        System.out.println("Service userRepository.getUserList()=" + this.userRepository.getUserList());        
    }

    public List<LoginUser> findAll() {
        return this.userRepository.getUserList();
    }

}
