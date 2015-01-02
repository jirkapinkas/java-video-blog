package com.java.vlog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.java.vlog.service.GroupIconService;

@WebServlet("/icon")
public class IconServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GroupIconService groupIconService;

	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO cachovat! tohle zbytecne zatezuje databazi
		String shortName = request.getParameter("shortName");
		byte[] icon = groupIconService.findIcon(shortName);
		ServletOutputStream out = response.getOutputStream();
		if (icon != null) {
			out.write(icon);
		}
	}
}
