package com.localhost;

import java.io.File;
import java.io.IOException;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

// Service Implementation Bean 

@MTOM(enabled = true, threshold = 1024)
@WebService(endpointInterface = "com.localhost.FileServer")
public class FileServerImpl implements FileServer {
	@Override
	public XRayType1 downloadFile(String fileName) {
		// Location of File in Web service
		XRayType1 objectVal = new XRayType1();

		DataHandler fileDataHandler = null;
		FileDataSource dataSource = new FileDataSource("/var/www/html/sample/" + fileName);
		fileDataHandler = new DataHandler(dataSource);

		objectVal.fileName = "sampl.pdf";
		objectVal.imageData = fileDataHandler;
		return objectVal;
	}

	@Override
	public DataHandler fileDownload(String filename) {
		return new DataHandler(new FileDataSource("/var/www/html/sample/" + filename));
	}
}
