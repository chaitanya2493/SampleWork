package com.mtomImpl;

import java.io.File;
import java.io.File;
import java.io.IOException;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

//Service Implementation Bean 
@MTOM(enabled = true, threshold = 1024)
@WebService(endpointInterface = "com.mtomImpl.FileServer")
public class FileServerImpl implements FileServer {
	public DataHandler downloadFile(String fileName) { // Location of File in Web service
		FileDataSource dataSource = new FileDataSource("/var/www/html/sample/" + fileName);
		DataHandler fileDataHandler = new DataHandler(dataSource);
		return fileDataHandler;
	}
}
