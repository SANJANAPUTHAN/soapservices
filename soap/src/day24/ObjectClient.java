package day24;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class ObjectClient
{
	public static void main(String[] args) throws Exception
	{
		URL url=new URL("http://localhost:1234/ws/hey?wsdl");
		
		QName qname=new QName("http://day24/","ComplexServiceService");
		
		Service service=Service.create(url,qname);
		
		ComplexInterface complex=service.getPort(ComplexInterface.class);
		
		Employee employee=complex.getEmployee("1");
		List<Employee> list=complex.getAllEmployees();
		
		Iterator<Employee> iterator=list.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
		System.out.println(employee.toString());
	}
	
}
