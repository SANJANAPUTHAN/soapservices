package User;

import javax.xml.ws.Endpoint;


public class HelloWorldPublisher 
{
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:9090/ws/hello", new HelloWorldService());
		System.out.println("service published...");
	}
	
}
	