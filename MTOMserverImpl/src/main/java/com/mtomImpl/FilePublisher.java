package com.mtomImpl;

import javax.xml.ws.Endpoint;
import com.mtomImpl.FileServerImpl; // Endpoint publisher 

public class FilePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/file", new FileServerImpl());
		System.out.println("Server is published!");
	}
}
