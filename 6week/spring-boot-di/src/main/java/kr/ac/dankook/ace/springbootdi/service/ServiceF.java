package kr.ac.dankook.ace.springbootdi.service;

import org.springframework.stereotype.Component;

@Component("service2")
public class ServiceF implements Service {

    @Override
    public String getInfo() {
        return "ServiceF's ServiceF's Info";
    }

}
