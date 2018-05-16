package com.mtomImpl.client;

import java.util.logging.Logger;

import javax.activation.DataHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mtomImpl.generatedClasses.FileRequest;

public class Main {
 
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("**/applicationContext.xml");
        FileDownloadService fileService = (FileDownloadService) context.getBean("fileDownloadService");
 
        FileRequest filename = new FileRequest();
        filename.setName("sampl.pdf");
        DataHandler conversionRate = fileService.getConversionRate(filename);

        System.out.println(conversionRate.getContentType());
    }
}