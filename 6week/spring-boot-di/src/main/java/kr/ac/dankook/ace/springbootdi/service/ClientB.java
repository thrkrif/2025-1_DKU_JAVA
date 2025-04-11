package kr.ac.dankook.ace.springbootdi.service;

public class ClientB implements Client {
    Service service;
	
	public ClientB(Service service) {
		this.service = service;
	}

    @Override
    public void doSomething() {
        System.out.println("ClientB: " + service.getInfo() + " " + service.getInfo());
    }

}
