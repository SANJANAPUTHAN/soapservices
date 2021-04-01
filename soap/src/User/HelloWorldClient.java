package User;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class HelloWorldClient 
{
	private static final String WSURL ="http://localhost:9090/ws/hello?wsdl";
	
	public static void main(String[] args) throws Exception
	{
		URL url=new URL(WSURL);
		QName qname=new QName("http://User/", "HelloWorldServiceService");
		Service service = Service.create(url, qname);
		HelloWorld hservice=service.getPort(HelloWorld.class);
		Map<String, Object> req =((BindingProvider)hservice).getRequestContext();
		req.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSURL);
		Map<String, List<String>> headers = new	HashMap();
		headers.put("Username",Collections.singletonList("ramu"));
		headers.put("Password",Collections.singletonList("secret"));
		req.put(MessageContext.HTTP_REQUEST_HEADERS,headers);
		System.out.println(hservice.getHelloWorldAsString());
	}
}
