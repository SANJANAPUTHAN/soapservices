package mtompack;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class MtomClient 
{
	public static void main(String[] args) throws Exception {
		
		URL url=new URL("http://localhost:9090/ws/hello?wsdl");
		
		QName qname=new QName("http://mtompack/","MtomServiceService");
		
		Service service=Service.create(url, qname);
		
		MtomInter mtominter=service.getPort(MtomInter.class);
		
		BindingProvider bp = (BindingProvider)mtominter;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
		Image img=ImageIO.read(new File("image.png"));
		System.out.println(img);
		mtominter.setImage(img,"image1.png");
		
	}
}
