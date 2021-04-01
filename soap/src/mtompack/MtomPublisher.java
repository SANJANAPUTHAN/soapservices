package mtompack;

import javax.xml.ws.Endpoint;

public class MtomPublisher
{
	public static void main(String[] args) throws Exception {
		
		Endpoint.publish("http://localhost:9090/ws/hello", new MtomService());
		System.out.println("service published...");
		
	}

}
