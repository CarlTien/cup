package com.hot.app.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		String result = "";
		Enumeration<String> attributes = request.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = attributes.nextElement();
			result = result + attribute + ":" + request.getAttribute(attribute) + "\n";
		}

		return "request.getRemoteAddr():" + request.getRemoteAddr() + ",getLocalAddr():" + request.getLocalAddr()
				+ ",getLocalPort():" + request.getLocalPort() + ",org.apache.tomcat.remoteAddr:"
				+ request.getAttribute("org.apache.tomcat.remoteAddr") + "----------------------\n" + result;
	}
}
