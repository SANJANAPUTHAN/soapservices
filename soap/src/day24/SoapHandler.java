package day24;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SoapHandler implements SOAPHandler<SOAPMessageContext>{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("message handle for request and response called...");
		SOAPMessage sm=context.getMessage();
		PrintStream out=new PrintStream(System.out);
		try {
			sm.writeTo(out);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println();
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("handle fault called....");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("connection closed....");
		
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("headers for request and response called...request and response headers");
		return null;
	}
	
	

}
