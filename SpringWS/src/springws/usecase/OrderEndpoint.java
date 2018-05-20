package springws.usecase;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;


@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@MTOM(enabled = true, threshold = 1024)
@Endpoint
public class OrderEndpoint {

    private static final String NAMESPACE = "http://www.springwssample.org/types";
    
    @PayloadRoot(localPart = "orderRequest", namespace = "http://www.springwssample.org/types")
    @ResponsePayload
    public Element processOrder(@RequestPayload Element request) throws ParserConfigurationException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = document.createElementNS(NAMESPACE, "orderResponse");
        response.appendChild(addElementWithValue(document, "item", "Item1"));
        response.appendChild(addElementWithValue(document, "quantity", "2"));
        response.appendChild(addElementWithValue(document, "city", "Ahmedabad"));
        response.appendChild(addElementWithValue(document, "country", "India"));
        response.appendChild(addElementWithValue(document, "price", "200.00"));
        response.appendChild(addElementWithValue(document, "isDeliver", "true"));
        return response;
    }
    
    private Element addElementWithValue(Document document, String element, String value){
        Element child = document.createElementNS(NAMESPACE, element);
        child.appendChild(document.createTextNode(value));
        return child;
    }
    private Element addElementWithDataHandler(Document document, String element, DocumentResponse value){
        Element child = document.createElementNS(NAMESPACE, element);
//        child.appendChild(document.createTextNode(value));
        child.appendChild((org.w3c.dom.Node) value);
        return child;
    }
    
    @PayloadRoot(localPart = "downloadDocumentRequest", namespace = "http://www.springwssample.org/types")
    @ResponsePayload
    public Element downloadDocument(@RequestPayload Element request) throws ParserConfigurationException, IOException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = document.createElementNS(NAMESPACE, "downloadDocumentResponse");
        
		DataHandler fileDataHandler = null;
		FileDataSource dataSource = new FileDataSource("/var/www/html/sample/sampl.pdf");
		fileDataHandler = new DataHandler(dataSource);
		 ByteArrayOutputStream output = new ByteArrayOutputStream();
		 fileDataHandler.writeTo(output);
			DocumentResponse response1 = new DocumentResponse();
			response1.imageData = fileDataHandler;
		response.appendChild(addElementWithDataHandler(document, "documentDetails", response1));

        return response;
    }
        
}