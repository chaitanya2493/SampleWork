package springws.usecase;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class DocumentResponse {
	public String fileName;
	@XmlMimeType("application/pdf")
	public DataHandler imageData;
}