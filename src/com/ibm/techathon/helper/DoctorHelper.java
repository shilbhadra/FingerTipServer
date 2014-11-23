package com.ibm.techathon.helper;


import java.io.File;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class DoctorHelper {

	
	String fileName = "Doctors.xml";
	String id;
	String name;
	String address;
	String contact;
	String distance;
	String availability;
	private double xLattitude;
	private double yLongitude;

	DoctorHelper() {

	} 

	public String getDoctorList(double latitude, double longitude) {

		int i = 0;
		String doctorXml = "";
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			 Document doctorDoc = builder.parse(getClass().getResourceAsStream(fileName));
			
			 doctorDoc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is "
					+ doctorDoc.getDocumentElement().getNodeName());
			UtilityHelper uHelper=new UtilityHelper();
			NodeList listOfDoctors = doctorDoc.getElementsByTagName("doctor");
			int totalDoctors = listOfDoctors.getLength();
			System.out.println("Total no of hospital : " + totalDoctors);
			StringBuffer sbuf = new StringBuffer(doctorXml);
			sbuf.append(IMedicalAidConstants.DOCTOR_HEADER_START_TAG);
			for (i = 0; i < totalDoctors; i++) {
				Node currNode = listOfDoctors.item(i);
				if (currNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstDoctorElement = (Element) currNode;

					// -------xCol--
					NodeList xCoList = firstDoctorElement
							.getElementsByTagName("xCoordinate");
					Element xCoElement = (Element) xCoList.item(0);
					NodeList textxCoList = xCoElement.getChildNodes();
					xLattitude = Double.parseDouble(textxCoList.item(0)
							.getNodeValue().trim());
					// -- end

					// -------yCol--
					NodeList yCoList = firstDoctorElement
							.getElementsByTagName("yCoordinate");
					Element yCoElement = (Element) yCoList.item(0);
					NodeList textyCoList = yCoElement.getChildNodes();
					yLongitude = Double.parseDouble(textyCoList.item(0)
							.getNodeValue().trim());
					
					

					boolean isAmbulanceValid = uHelper.checkLocationValidity(
							xLattitude, yLongitude, latitude, longitude);
					
					
					// -- end
				//	System.out.println(isAmbulanceValid);
					// -------Name--
					if (isAmbulanceValid) {

						NodeList nameList = firstDoctorElement
								.getElementsByTagName("name");
						Element nameElement = (Element) nameList.item(0);
						NodeList textNameList = nameElement.getChildNodes();
						name = textNameList.item(0).getNodeValue().trim();
						// -- end

						// -------ID--
						NodeList iDList = firstDoctorElement
								.getElementsByTagName("id");
						Element idElement = (Element) iDList.item(0);
						NodeList textIdList = idElement.getChildNodes();
						id = textIdList.item(0).getNodeValue().trim();
						// -- end

						// -------Address--
						NodeList addressList = firstDoctorElement
								.getElementsByTagName("address");
						Element addressElement = (Element) addressList.item(0);
						NodeList textAddressList = addressElement
								.getChildNodes();
						address = textAddressList.item(0).getNodeValue().trim();
						// -- end

						// -------Contact--
						NodeList contactList = firstDoctorElement
								.getElementsByTagName("contact");
						Element contactElement = (Element) contactList.item(0);
						NodeList textContactList = contactElement
								.getChildNodes();
						contact = textContactList.item(0).getNodeValue().trim();
						// -- end

						// -------Department
						NodeList deptList = firstDoctorElement
								.getElementsByTagName("availability");
						Element deptElement = (Element) deptList.item(0);
						NodeList textDeptList = deptElement
								.getChildNodes();
						availability = textDeptList.item(0).getNodeValue().trim();
						
						// -- end
						
					
						distance=uHelper.getCalculatedDistance();
						
				sbuf.append("\n" + IMedicalAidConstants.DOCTOR_START_TAG);
				sbuf.append("\n" + IMedicalAidConstants.ID_START_TAG + id
						+ IMedicalAidConstants.ID_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.NAME_START_TAG + name
						+ IMedicalAidConstants.NAME_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.ADDRESS_START_TAG
						+ address + IMedicalAidConstants.ADDRESS_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.CONTACT_START_TAG
						+ contact + IMedicalAidConstants.CONTACT_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.DISTANCE_START_TAG
						+ distance + IMedicalAidConstants.DISTANCE_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.AVL_START_TAG
						+ availability + IMedicalAidConstants.AVL_END_TAG);
				
				sbuf.append("\n" + IMedicalAidConstants.DOCTOR_END_TAG);
				
				
					}// if Boolean
				}// end of if clause
			}// end for
			sbuf.append("\n" + IMedicalAidConstants.DOCTOR_HEADER_END_TAG+"\n");	
			doctorXml =sbuf.toString();
			System.out.println(doctorXml);

		} catch (Exception e) {

			System.out.println(e.toString());
		}
		return doctorXml;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoctorHelper ahelper = new DoctorHelper();
		ahelper.getDoctorList(5.3, 4.6);

	}
}
