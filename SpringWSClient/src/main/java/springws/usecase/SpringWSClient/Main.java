package springws.usecase.SpringWSClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.activation.DataHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import springws.usecase.generatedClasses.OrderRequest;
import springws.usecase.generatedClasses.OrderResponse;

import springws.usecase.generatedClasses.DownloadDocumentResponse;

//import com.mtomImpl.generatedClasses.FileRequest;

public class Main {

	public static void main(String[] args) {


		ApplicationContext context = new FileSystemXmlApplicationContext("**/applicationContext.xml");

		try {
			FileDownloadService currencyService = context.getBean(FileDownloadService.class);
			//OrderResponse conversionRate = currencyService.getOrderDetails("123");
			//System.out.println(conversionRate.getCity());

			DownloadDocumentResponse conversionRate1 = currencyService.getDocumentDetails("sa");

			DataHandler documentdetails = conversionRate1.getDocumentDetails();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			
			//final InputStream in = documentdetails.getInputStream();
			//byte[] byteArray= org.apache.commons.io.IOUtils.toByteArray(in);
			//System.out.println(" 2:" + Arrays.toString(byteArray));
			try {
				documentdetails.writeTo(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("error");
				e.printStackTrace();
			}
			byte[] bytearray = output.toByteArray();

			System.out.println(" 4:" + Arrays.toString(bytearray));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}