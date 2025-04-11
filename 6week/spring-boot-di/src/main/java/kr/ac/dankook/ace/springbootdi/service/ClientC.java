package kr.ac.dankook.ace.springbootdi.service;

public class ClientC implements Client {
    Service service;
	
	public ClientC(Service service) {
		this.service = service;
	}

    @Override
    public void doSomething() {
        System.out.println("ClientC: " + service.getInfo() + " " + service.getInfo() + " " + service.getInfo());
    }

}
