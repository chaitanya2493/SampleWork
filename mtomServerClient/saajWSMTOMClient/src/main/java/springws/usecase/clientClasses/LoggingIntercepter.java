package springws.usecase.clientClasses;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

/*public class LoggingIntercepter implements clientinterceptor {
	private static final logger logger = loggerfactory.getlogger(logbackinterceptor.class);

	public boolean handlerequest(messagecontext messagecontext) throws webserviceclientexception {
		logger.debug("sent request sample [" + messagecontext.getrequest() + "]");
		return true;
	}

	public boolean handleresponse(messagecontext messagecontext) throws webserviceclientexception {
		logger.debug("received response sample [" + messagecontext.getresponse() + "] request ["
				+ messagecontext.getrequest() + "]");
		return true;
	}

	@override
	public boolean handlefault(messagecontext messagecontext) throws webserviceclientexception { // todo auto-generated
																									// method stub
		return false;
	}

	@override
	public void aftercompletion(messagecontext messagecontext, exception ex) throws webserviceclientexception { // todo
																												// auto-generated
																												// method
																												// stub
	}
}*/

public class LoggingIntercepter implements ClientInterceptor {

	public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
		System.out.println("### SOAP RESPONSE ###");
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			messageContext.getResponse().writeTo(buffer);
			String payload = buffer.toString(java.nio.charset.StandardCharsets.UTF_8.name());
			System.out.println(payload);
		} catch (IOException e) {
			throw new WebServiceClientException("Can not write the SOAP response into the out stream", e) {
				private static final long serialVersionUID = -7118480620416458069L;
			};
		}

		return true;
	}

	public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {

		System.out.println("### SOAP REQUEST ###");
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			messageContext.getRequest().writeTo(buffer);
			String payload = buffer.toString(java.nio.charset.StandardCharsets.UTF_8.name());
			System.out.println(payload);
		} catch (IOException e) {
			throw new WebServiceClientException("Can not write the SOAP request into the out stream", e) {
				private static final long serialVersionUID = -7118480620416458069L;
			};
		}

		return true;
	}

	public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
		System.out.println("### SOAP FAULT ###");
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			messageContext.getResponse().writeTo(buffer);
			String payload = buffer.toString(java.nio.charset.StandardCharsets.UTF_8.name());
			System.out.println(payload);
		} catch (IOException e) {
			throw new WebServiceClientException("Can not write the SOAP fault into the out stream", e) {
				private static final long serialVersionUID = 3538336091916808141L;
			};
		}

		return true;
	}
}
