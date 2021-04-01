package handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;




public class MacAddressValidatorHandler implements SOAPHandler<SOAPMessageContext>
{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		Boolean isrequest=(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(!isrequest)
		{
			try
			{
				SOAPMessage soapMsg =context.getMessage();
				SOAPEnvelope soapEnv =soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnv.getHeader();
				if(soapHeader==null)
				{
					soapHeader=soapEnv.addHeader();
					generateSoapErrMsg(soapMsg,"no soap header");
				}
				
				Iterator iter=soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				if(iter==null || !iter.hasNext())
				{
					generateSoapErrMsg(soapMsg, "next header");
				}
				Node actnode=(Node)iter.next();
				String value=(actnode==null)?null:actnode.getValue();
				if(value==null)
				{
					generateSoapErrMsg(soapMsg, value);
				}
				if(!value.equals("90-4C-E5-44-B9-8F11111"))
				{
					generateSoapErrMsg(soapMsg, "invalied");
				}
				soapMsg.writeTo(System.out);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	

	private void generateSoapErrMsg(SOAPMessage soapMsg, String string) {
		// TODO Auto-generated method stub
		try
		{
			SOAPBody soapBody =	soapMsg.getSOAPPart().getEnvelope().getBody();
		    SOAPFault soapFault = soapBody.addFault();
			soapFault.setFaultString(string);
			throw new SOAPFaultException(soapFault);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}



	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
