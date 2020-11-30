package yolo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StringContent;

import yolo.FileReader;

@WebServlet("/servlet")
public class Servlet1 extends HttpServlet implements Info{
	
		private static final long serialVersionUID = 1L;
		
		public int cmd; 
		public static int currentIndex = 0;
		public static final int SIZE = 20;
		public String FileName;
		public static String DataDirectory = "/Users/Jarvis/Desktop/op_files"; //Place where the files are stored      
		public static FileReader Files[] = new FileReader[SIZE]; //Array that contains all files
		public static String infoContent1 = " "; //for dynamic html
		public static String infoContent2 = " "; //for dynamic html
		public static String infoContent3 = " "; //for dynamic html
		public static String infoContent4 = " "; //for dynamic html
		
		//Loading Files into Array
		public static void loadFiles(String DataDirectory) 
		{
        File dir = new File(DataDirectory);
        for (File f : dir.listFiles())
        {
            if(f.getName().contains(".csv"))
            {
                Files[currentIndex] = new CSVReader();
                Files[currentIndex].LoadFile(f.getName());
                currentIndex++;
            }
        }
        CSVReader fi = new CSVReader("/Users/Jarvis/Desktop/op_files/Arenas.csv");
        Files[0] = fi;
     
        Files[0].LoadFile("/Users/Jarvis/Desktop/op_files/Arenas.csv");
        //currentIndex++;
        
        System.out.println("Files loaded");
		
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
	    	 String s = request.getParameter("textfield");
	    	 String s2 = request.getParameter("load");  // text field used to load files
	    	 if(!s2.isEmpty())
	    	 {
	    		 Servlet1.loadFiles(DataDirectory); 
	    		 RequestDispatcher r = request.getRequestDispatcher("MainPage.jsp");
				r.forward(request, response);
	    	 }
	    	 else
	    	 {
		
	    	System.out.println("in servlet");
	    	
			if(s.isEmpty())
			{	
				RequestDispatcher r = request.getRequestDispatcher("MainPage.jsp");
				r.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				
				
				FileName = s;
                		FileName = FileName.toLowerCase();
                		FileReader Temp[] = new FileReader[SIZE];   //Temporary Array for Search Options
                		int holder = 0;
                		for(int i = 0; i < currentIndex; i++)
                		{
                 		   if(Files[i].getFileName().toLowerCase().contains(FileName))       //Transfers to temp array if search matches
                   		   {
                       		 	Temp[holder] = new CSVReader();
                       			 Temp[holder].Name = Files[i].getFileName();
                        		Temp[holder].FileContent = Files[i].getRawFileContent();
                        		System.out.println(holder + ": " + Temp[holder].getFileName());
                        		holder++;
                    		    }
                		}
                		if(holder == 0)
                		{
                    			System.out.println("No Files Found");
                    			infoContent1 = "No Files Found"; 
				 	infoContent4 = "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><hr>";
               			 }
                		else if(holder == 1)
                		{
                    			System.out.println(Temp[0].getFileName());
                    			infoContent1 = Temp[0].getFileName();                
                    			infoContent2 = ArenaDSI.toString();
                    			System.out.println(Temp[0].getFileContent());
					infoContent3 = Temp[0].getFileContent();
                  			infoContent4 = " ";
                    
                		}
                
		pw.println("<!DOCTYPE html><html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n" + "<link rel =\"stylesheet\" href= \"styles.css\">\n" + 
                		"<title>Windsor's Open Data Portal</title>" + "</head>\n" + "<body id= 'servlet'>\n" + 
                		"<h2>The City of Windsor's Open Data Portal</h2>\n" + "<hr>");
                
                pw.println("<h3> You searched for: " + s + "</h3>");
                pw.println("<h3>" + infoContent1 + "<h3>");
                pw.println("<p>" + infoContent2 + "<p>");
                pw.println("<p>" + infoContent3 + "<p>");
                pw.println("<p>" + infoContent4 + "<p>");
                
                pw.println("<img src=\"skyline.jpg\" alt=\"skyline\"> <a href = \"MainPage.jsp\"> Return to main page </a>" + "</body>\n" + "</html>");
				System.out.println("in service");
				clearInfoContent();
			}
			
	     }
	     }
	
	   public static void clearInfoContent()
	   {
		   infoContent1 = " ";infoContent2 = " ";infoContent3 = " ";infoContent4 = " ";
	   }
	}
