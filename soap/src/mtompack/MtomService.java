package mtompack;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(endpointInterface = "mtompack.MtomInter")
@HandlerChain(file="mtompack/handler-chain.xml")
public class MtomService implements MtomInter
{

	@WebMethod
	@Override
	public Image getImage(String name) throws Exception {
		File f=new File(name);
		return ImageIO.read(f);
	}

	@WebMethod
	@Override
	public void setImage(Image image, String name) {
		try
		{
			File fos=new File(name);
			BufferedImage bimage=(BufferedImage)image;
			ImageIO.write(bimage, "png", fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
