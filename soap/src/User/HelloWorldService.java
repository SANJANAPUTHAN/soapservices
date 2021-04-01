package User;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "User.HelloWorld")
public class HelloWorldService implements HelloWorld
{

	@Resource
	WebServiceContext wsctx;
	
	
	@WebMethod
	@Override
	public String getHelloWorldAsString()
	{
		MessageContext msg=wsctx.getMessageContext();
		Map httpheaders=(Map)msg.get(MessageContext.HTTP_REQUEST_HEADERS);
		List users=(List)httpheaders.get("Username");
		List passwordlist=(List)httpheaders.get("Password");
		
		String username="";
		String password="";
		
		if(users!=null)
		{
			username=users.get(0).toString();
		}
		if(passwordlist!=null)
		{
			password=passwordlist.get(0).toString();
		}
		
		if(username.equals("ramu") &&  password.equals("secret"))
		{
			return "valid client";
		}
		else
		{
			return "invalid client";
		}
	}

}
