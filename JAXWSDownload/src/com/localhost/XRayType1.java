package com.localhost;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class XRayType1 {
	public String fileName;
	@XmlMimeType("application/pdf")
	public DataHandler imageData;
}