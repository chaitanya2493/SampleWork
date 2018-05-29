package com.journaldev.spring.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.activation.DataHandler;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.wsdl.util.IOUtils;
import com.journaldev.spring.model.User;

import springws.usecase.clientClasses.*;

@Controller
public class HomeController {

	static Logger logger = Logger.getLogger(HomeController.class); 
	SaajMtomClient saajMtomClient;

	public SaajMtomClient getSaajMtomClient() {
		return saajMtomClient;
	}

	public void setSaajMtomClient(SaajMtomClient saajMtomClient) {
		this.saajMtomClient = saajMtomClient;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("intoservice");
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		DataHandler datacontent;
		try {
			datacontent = saajMtomClient.loadContent("sample.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "user";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void getFile(HttpServletResponse response) {
		DataHandler datacontent;
		logger.info("intoservice");
		byte[] fileStream = null;
		try {
			datacontent = saajMtomClient.loadContent("sample.pdf");
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			datacontent.writeTo(os);
			fileStream = os.toByteArray();
		      
			response.setHeader("Content-Disposition", "attachment; filename=Accepted.pdf");
			response.setContentType("application/pdf");
		    response.setContentLength(fileStream.length);
		    response.setHeader("Pragma", "public");
		    response.setHeader("Cache-Control", "cache");
		    response.setHeader("Cache-Control", "must-revalidate");
		    
			ServletOutputStream outputStream = response.getOutputStream();
		    outputStream.write(fileStream);

			response.flushBuffer();
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
}
