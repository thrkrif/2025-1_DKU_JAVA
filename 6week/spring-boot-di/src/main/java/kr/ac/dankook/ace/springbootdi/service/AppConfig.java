package kr.ac.dankook.ace.springbootdi.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean("service3") 
	public Service getService3() {
		return new ServiceG();
	}
 
    @Bean("client2") // client2 <- service2
	public Client getClient2(@Qualifier("service2") Service service2) {
		return new ClientB(service2);
	}
	
    @Bean("client3") // client3 <- service3
	public Client getClient3(@Qualifier("service3") Service service3) {
		return new ClientC(service3);
	}

}
