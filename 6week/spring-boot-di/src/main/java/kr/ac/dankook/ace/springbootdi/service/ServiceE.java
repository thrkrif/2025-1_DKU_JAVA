package kr.ac.dankook.ace.springbootdi.service;

import org.springframework.stereotype.Component;

@Component("service1")
public class ServiceE implements Service {

    @Override
    public String getInfo() {
        return "ServiceE's Info";
    }

}
