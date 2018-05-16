package com.mtomImpl.client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.mtomImpl.generatedClasses.FileRequest;
import com.mtomImpl.generatedClasses.ObjectFactory;
import com.mtomImpl.generatedClasses.XRayType1;

import javax.activation.DataHandler;

@Service
public class FileDownloadService {
	@Autowired
	private WebServiceTemplate webServiceTemplate;

	public DataHandler getConversionRate(FileRequest fileName) {

		JAXBContext jc;
		//JAXBElement<XRayType1> response = null;
		DataHandler response = null;
		
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
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return response;
	}
}