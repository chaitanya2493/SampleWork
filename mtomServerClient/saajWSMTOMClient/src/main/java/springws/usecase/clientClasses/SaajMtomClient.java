package springws.usecase.clientClasses;

import java.io.File;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.URLDataSource;

import org.springframework.util.StopWatch;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import springws.usecase.generatedClasses.LoadContentRequest;
import springws.usecase.generatedClasses.LoadContentResponse;
import springws.usecase.generatedClasses.ObjectFactory;
import springws.usecase.generatedClasses.StoreContentRequest;

import org.springframework.ws.server.endpoint.interceptor.*;


/**
 * Simple SAAJ based MTOM enabled client
 * 
 * @author Gyula Szalai <gyula.szalai@vanio.hu>
 */
public class SaajMtomClient extends WebServiceGatewaySupport {

    /** JAXB object factory */
    private final ObjectFactory objectFactory = new ObjectFactory();

    /** Stopwatch to measure times */
    private final StopWatch stopWatch = new StopWatch(getClass().getSimpleName());

    /**
     * Constructor
     * @param messageFactory The SAAJ message factory
     */
    public SaajMtomClient(SaajSoapMessageFactory messageFactory) {
        super(messageFactory);
        ClientInterceptor[] interceptors = new ClientInterceptor[1]; 
        interceptors[0] = new LoggingIntercepter(); 
        getWebServiceTemplate().setInterceptors(interceptors);
    }

    /**
     * Sends the test content file to the WebService
     */
    public void storeContent() {
        StoreContentRequest storeContentRequest = objectFactory.createStoreContentRequest();
        storeContentRequest.setName(ClientUtil.TEST_CONTENT_NAME);
        storeContentRequest.setContent(new DataHandler(new URLDataSource(ClientUtil.TEST_CONTENT_URL)));
        getWebServiceTemplate().marshalSendAndReceive(storeContentRequest);
        
    }

    /**
     * Loads the test content from the WebService
     * @throws IOException If an IO error occurs
     */
    public DataHandler loadContent(String fileName) throws IOException {
        LoadContentRequest loadContentRequest = objectFactory.createLoadContentRequest();

//        String tmpDir = System.getProperty("java.io.tmpdir");
        
        
        String tmpDir = "/var/www/html/sample/";
        File outFile = new File(tmpDir, "saajtest.txt");
        
        long freeBefore = Runtime.getRuntime().freeMemory();
        loadContentRequest.setName(fileName);
        LoadContentResponse loadImageResponse = (LoadContentResponse) getWebServiceTemplate().marshalSendAndReceive(loadContentRequest);
        
        logger.info(loadImageResponse );
        
        DataHandler content = loadImageResponse.getContent();
        
        long freeAfter = Runtime.getRuntime().freeMemory();
        logger.info("Memory usage [kB]: " + ((freeAfter - freeBefore)/1024));
        
        long size = ClientUtil.saveContentToFile(content, outFile);
        
        logger.info("Received file size [kB]: " + size);
        return content;
    }

}
