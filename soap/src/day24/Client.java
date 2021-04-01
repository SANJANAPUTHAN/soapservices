package day24;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client
{
	public static void main(String[] args) throws Exception 
	{
		URL url=new URL("http://localhost:9090/ws/hello?wsdl");
		
		QName qname=new QName("http://day24/","HelloServiceImplService");
		
		Service service=Service.create(url,qname);
		
		HelloService hservice=service.getPort(HelloService.class);
		
		String result=hservice.HelloSeriveDemo("sanjana");
		
		System.out.println("the result is..."+result);
		
		
	}

}
