
package hu.vanio.springwsmtom.wstypes;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hu.vanio.springwsmtom.wstypes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hu.vanio.springwsmtom.wstypes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadContentRequest }
     * 
     */
    public LoadContentRequest createLoadContentRequest() {
        return new LoadContentRequest();
    }

    /**
     * Create an instance of {@link LoadContentResponse }
     * 
     */
    public LoadContentResponse createLoadContentResponse() {
        return new LoadContentResponse();
    }

    /**
     * Create an instance of {@link StoreContentRequest }
     * 
     */
    public StoreContentRequest createStoreContentRequest() {
        return new StoreContentRequest();
    }

    /**
     * Create an instance of {@link StoreContentResponse }
     * 
     */
    public StoreContentResponse createStoreContentResponse() {
        return new StoreContentResponse();
    }

}
