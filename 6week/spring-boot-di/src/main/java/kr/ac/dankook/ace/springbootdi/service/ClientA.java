package kr.ac.dankook.ace.springbootdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("client1")
public class ClientA implements Client {
    @Autowired
	private Service service1; // client1 <- service1

    @Override
    public void doSomething() {
        System.out.println("ClientA: " + service1.getInfo());	
    }

}
