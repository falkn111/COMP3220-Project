package yolo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
	
	
		private static final long serialVersionUID = 1L;
	       
	    
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
	    	String s = request.getParameter("textfield");
		
			if(s.isEmpty())
			{
				RequestDispatcher req = request.getRequestDispatcher("MainPage.jsp");
				req.include(request, response);
				
			}
			else
			{
				RequestDispatcher req = request.getRequestDispatcher("dataSetPage.jsp");
				req.forward(request, response);
			}
			
		}
	
	     
	}

