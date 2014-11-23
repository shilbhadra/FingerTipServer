package com.ibm.techathon.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.ibm.techathon.helper.FingerTipMedicalAidHelper;

public class FingerTipMedicalAidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FingerTipMedicalAidServlet() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String medical=request.getParameter("medical").trim();
		String address="";
	    FingerTipMedicalAidHelper helper=new FingerTipMedicalAidHelper();
	 
	    String paramLat=request.getParameter("lattitude");
	    String paramLong=request.getParameter("longitude");
	    System.out.println("latttude " + paramLat+" Longitude "+paramLong);
	    if(medical.equalsIgnoreCase("ambulance")){
	    address=helper.getAmbulance(paramLat,paramLong);
	    
	  //  System.out.print("FingertipServelt\n" + address);
	    }
	    if(medical.equalsIgnoreCase("hospital")){
		address=helper.getHospital(paramLat,paramLong);
		}
	    if(medical.equalsIgnoreCase("doctors")){
		address=helper.getDoctors(paramLat,paramLong);
		}
	    if(medical.equalsIgnoreCase("medstore")){
		address=helper.getMedicineStore(medical);
		}
	    request.setAttribute("address",address);
	    
	    response.getWriter().write(address);
	    
	//	ServletContext context = getServletContext();
	  //  RequestDispatcher dispatcher = context.getRequestDispatcher("/response.jsp");
	  //  dispatcher.forward(request,response);
	}
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medical=request.getParameter("medical").trim();
		String address="";
	    FingerTipMedicalAidHelper helper=new FingerTipMedicalAidHelper();
	 
	    String paramLat=request.getParameter("lattitude");
	    String paramLong=request.getParameter("longitude");
	    System.out.println("latttude " + paramLat+" Longitude "+paramLong);
	    if(medical.equalsIgnoreCase("ambulance")){
	    address=helper.getAmbulance(paramLat,paramLong);
	    
	   
	    }
	    if(medical.equalsIgnoreCase("hospital")){
		address=helper.getHospital(paramLat,paramLong);
		 System.out.print("FingertipServelt\n" + address);
		}
	    if(medical.equalsIgnoreCase("doctors")){
		address=helper.getDoctors(paramLat,paramLong); 
		}
	    if(medical.equalsIgnoreCase("medstore")){
		address=helper.getMedicineStore(medical);
		}
	    request.setAttribute("address",address);
	    
	    response.getWriter().write(address);
	    
	//	ServletContext context = getServletContext();
	  //  RequestDispatcher dispatcher = context.getRequestDispatcher("/response.jsp");
	  //  dispatcher.forward(request,response);
	}

}
