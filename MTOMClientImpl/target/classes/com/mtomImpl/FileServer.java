
package com.mtomImpl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FileServer", targetNamespace = "http://mtomImpl.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FileServer {


    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod(action = "http://mtomImpl.com/FileServer/downloadFile/")
    @WebResult(partName = "return")
    public byte[] downloadFile(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
