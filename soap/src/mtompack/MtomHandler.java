package mtompack;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class MtomHandler implements SOAPHandler<SOAPMessageContext>
{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("message request and response...");
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("fault handled...");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("request and response closed...");
		
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("called during initialisation...");
		return null;
	}

}
