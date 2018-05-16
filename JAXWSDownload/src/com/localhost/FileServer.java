package com.localhost;

import java.io.File;
import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.annotation.XmlMimeType;

// Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)

public interface FileServer {
	// download a File from server
	@WebMethod
	public XRayType1 downloadFile(String fileName);
	
	@XmlMimeType("application/pdf")
	@WebMethod
	public DataHandler fileDownload(String filename);
}