package day24;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService
{
	@WebMethod
	public String HelloSeriveDemo(String name);

}
