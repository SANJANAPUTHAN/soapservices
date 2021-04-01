package day24;

import javax.xml.ws.Endpoint;

public class ComplexPublisher
{
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1234/ws/hey", new ComplexService());
		System.out.println("service published...");
	}

}
