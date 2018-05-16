package com.localhost;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import com.localhost.FileServerImpl;

//Endpoint publisher  
public class FilePublisher {
	
	private static final String MY_SERVICE_XSD = "XRayType1.xsd";
	public static void main(String[] args) {
		

		Endpoint ep = Endpoint.create(new FileServerImpl());

        ep.setMetadata(Arrays.asList(sourceFromResource(MY_SERVICE_XSD)));
        

        ep.publish("http://localhost:9000/ws/file");
		System.out.println("Server is published!");
	}
	private static Source sourceFromResource(String name) {
        URL resource = FilePublisher.class.getResource(name);
        String systemId = resource.toExternalForm();
        InputStream inputStream;
        try {
            inputStream = resource.openStream();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create InputStream from resource \""+ name +"\"", e);
        }
        return new StreamSource(inputStream, systemId);
    }
}
