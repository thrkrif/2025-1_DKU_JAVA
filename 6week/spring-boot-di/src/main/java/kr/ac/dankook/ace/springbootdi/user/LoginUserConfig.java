package kr.ac.dankook.ace.springbootdi.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginUserConfig {
			
	// Configuring userList
    @Bean
	protected List<LoginUser> userList() {
		System.out.println("LoginUserConfig userList()");
		List<LoginUser> userList = new ArrayList<>();
        userList.add(new LoginUser("Kim", 12345));
        userList.add(new LoginUser("Lee", 6789));
        userList.add(new LoginUser("Park", 321));
        userList.add(new LoginUser("DIS", 98765));
        return userList;
	}
	
	// Configuring LoginUserRepository with userList
	@Bean
	public LoginUserRepository userRepository() {
		LoginUserRepository userRepository = new LoginUserRepository();
		userRepository.setUserList(userList()); 
		return userRepository;
	}

}
