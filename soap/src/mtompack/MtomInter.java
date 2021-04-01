package mtompack;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MtomInter 
{
	@WebMethod
	public Image getImage(String name) throws Exception;
	public void setImage(Image image,String name);

}
