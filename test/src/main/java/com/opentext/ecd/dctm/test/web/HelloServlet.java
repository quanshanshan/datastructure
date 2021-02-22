package com.opentext.ecd.dctm.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		 
		 resp.setContentType("text/html");
		 PrintWriter writer = resp.getWriter();
		  writer.write("<h1>Hello, world!</h1>");
	        // 最后不要忘记flush强制输出:
	        writer.flush();
		    }

}
