package springws.usecase.SpringWSClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import springws.usecase.generatedClasses.DownloadDocumentResponse;
import springws.usecase.generatedClasses.DownloadDocumentRequest;
import springws.usecase.generatedClasses.OrderRequest;
import springws.usecase.generatedClasses.OrderResponse;
import springws.usecase.generatedClasses.ObjectFactory;

import javax.activation.DataHandler;

@Service
public class FileDownloadService {

	private static final Logger logger = Logger.getLogger(FileDownloadService.class);
    private static final ObjectFactory WS_CLIENT_FACTORY = new ObjectFactory();

    private  WebServiceTemplate webServiceTemplate;

    public FileDownloadService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    
    public OrderResponse getOrderDetails(String orderRef) {
        logger.debug("Preparing CancelOrderRequest.....");
        OrderRequest request =   WS_CLIENT_FACTORY.createOrderRequest();
        request.setItem(orderRef);

        logger.debug("Invoking Web service Operation[CancelOrder]....");
        OrderResponse response = (OrderResponse) webServiceTemplate.marshalSendAndReceive(request);

        logger.debug("Has the order cancelled: " + response.getCity());

        return response;
    }
    
    public DownloadDocumentResponse getDocumentDetails(String filename) {
    	DownloadDocumentResponse response= null;
    	try {
    	webServiceTemplate.setCheckConnectionForFault(true);
        logger.debug("Preparing CancelOrderRequest.....");
        DownloadDocumentRequest request =   WS_CLIENT_FACTORY.createDownloadDocumentRequest();
        request.setFilename(filename);

        logger.debug("Invoking Web service Operation[CancelOrder]....");
         response = (DownloadDocumentResponse) webServiceTemplate.marshalSendAndReceive(request);

        System.out.println("Has the order cancelled: " + response.getDocumentDetails().getContentType());

       
    	}catch(Exception e) {
    		logger.debug(e.fillInStackTrace());
    		logger.debug(e.getMessage());
    		logger.debug(e.getStackTrace());
    	}
    	 return response;
    }
    
//	public DataHandler getConversionRate(String fileName) {
//
//		JAXBContext jc;
//		JAXBElement<XRayType1> response = null;
//		DataHandler response = null;
//		
//		try {
//			ObjectFactory factory = new ObjectFactory();
//			//FileRequest requestData = factory.createFileRequest();
//			//JAXBElement<FileRequest> request = factory.createFileRequest() .createFileRequest();
//			
//			jc = JAXBContext.newInstance("com.mtomImpl.generatedClasses");
//
//			Marshaller marshaller = jc.createMarshaller();
//
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//			FileRequest requestData = new ObjectFactory().createFileRequest();
//			requestData.setName(fileName.getName());
//			
//			response = (JAXBElement<XRayType1>) webServiceTemplate.marshalSendAndReceive(requestData);
//			
//		    TListFlights tListFlights = factory.createTListFlights();
//
//		    JAXBElement<TListFlights> request = factory.createListFlightsRequest(tListFlights);
//
//		    JAXBElement<TFlightsResponse> response = (JAXBElement<TFlightsResponse>) webServiceTemplate
//		        .marshalSendAndReceive(request, new WebServiceMessageCallback() {
//
//			
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
//		return response;
//	}
}