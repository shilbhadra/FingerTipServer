package com.ibm.techathon.helper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class AmbulanceHelper {

	Document ambDoc;
	String fileName = "Ambulance.xml";
	String id;
	String name;
	String address;
	String contact;
	String distance;
	String latitudeStr;
	String longitudeStr;
	private double xLattitude;
	private double yLongitude;

	AmbulanceHelper() {

	} 

	public String getAmbulanceList(double latitude, double longitude) {

		int i = 0;
		String ambulanceXml = "";
		try {
			
			//File fAmbulance=new File("fileName");
		//	String filePath=fAmbulance.getPath();
		//	System.out.println("File Path" + filePath);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			//Document ambDoc = builder.parse(new File(filePath+fileName));
			 Document ambDoc = builder.parse(getClass().getResourceAsStream("Ambulance.xml"));
			// String nameTagElmValue = getNodeValue(doc, "Ambulances",
			// "Ambulance");

			ambDoc.getDocumentElement().normalize();
			
			System.out.println("Root element of the doc is " + ambDoc.getDocumentElement().getNodeName());
			
			UtilityHelper uHelper=new UtilityHelper();
			NodeList listOfAmbulance = ambDoc.getElementsByTagName("ambulance");
			
			int totalAmbulances = listOfAmbulance.getLength();
			
			System.out.println("Total no of Ambulance : " + totalAmbulances);
			
			StringBuffer sbuf = new StringBuffer(ambulanceXml);
			sbuf.append(IMedicalAidConstants.AMBULANCE_HEADER_START_TAG);
			
			for (i = 0; i < totalAmbulances; i++) {
				
				Node currNode = listOfAmbulance.item(i);
				
				if (currNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstAmbulanceElement = (Element) currNode;

					// -------xCol--
					NodeList xCoList = firstAmbulanceElement.getElementsByTagName("xCoordinate");
					Element xCoElement = (Element) xCoList.item(0);
					NodeList textxCoList = xCoElement.getChildNodes();
					xLattitude = Double.parseDouble(textxCoList.item(0).getNodeValue().trim());
					// -- end

					// -------yCol--
					NodeList yCoList = firstAmbulanceElement.getElementsByTagName("yCoordinate");
					Element yCoElement = (Element) yCoList.item(0);
					NodeList textyCoList = yCoElement.getChildNodes();
					yLongitude = Double.parseDouble(textyCoList.item(0).getNodeValue().trim());
					
					

					boolean isAmbulanceValid = uHelper.checkLocationValidity(xLattitude, yLongitude, latitude, longitude);
					
					
					// -- end
					//	System.out.println(isAmbulanceValid);
					// -------Name--
					if (isAmbulanceValid) {

						NodeList nameList = firstAmbulanceElement.getElementsByTagName("name");
						Element nameElement = (Element) nameList.item(0);
						NodeList textNameList = nameElement.getChildNodes();
						name = textNameList.item(0).getNodeValue().trim();
						// -- end

						// -------ID--
						NodeList iDList = firstAmbulanceElement.getElementsByTagName("id");
						Element idElement = (Element) iDList.item(0);
						NodeList textIdList = idElement.getChildNodes();
						id = textIdList.item(0).getNodeValue().trim();
						// -- end

						// -------Address--
						NodeList addressList = firstAmbulanceElement.getElementsByTagName("address");
						Element addressElement = (Element) addressList.item(0);
						NodeList textAddressList = addressElement.getChildNodes();
						address = textAddressList.item(0).getNodeValue().trim();
						// -- end

						// -------Contact--
						NodeList contactList = firstAmbulanceElement.getElementsByTagName("contact");
						Element contactElement = (Element) contactList.item(0);
						NodeList textContactList = contactElement.getChildNodes();
						contact = textContactList.item(0).getNodeValue().trim();
						// -- end
						
						// -------Latitude--
						NodeList latitudeList = firstAmbulanceElement.getElementsByTagName("xCoordinate");
						Element latitudeElement = (Element) latitudeList.item(0);
						NodeList textlatitudeList = latitudeElement.getChildNodes();
						latitudeStr = textlatitudeList.item(0).getNodeValue().trim();
						// -- end
						
						// -------Longitude--
						NodeList longitudeList = firstAmbulanceElement.getElementsByTagName("yCoordinate");
						Element longitudeElement = (Element) longitudeList.item(0);
						NodeList textlongitudeList = longitudeElement.getChildNodes();
						longitudeStr = textlongitudeList.item(0).getNodeValue().trim();
						// -- end
						
						distance=uHelper.getCalculatedDistance();
				
						sbuf.append("\n" + IMedicalAidConstants.AMBULANCE_START_TAG);
						sbuf.append("\n" + IMedicalAidConstants.ID_START_TAG + id + IMedicalAidConstants.ID_END_TAG);
						sbuf.append("\n" + IMedicalAidConstants.NAME_START_TAG + name + IMedicalAidConstants.NAME_END_TAG);
						sbuf.append("\n" + IMedicalAidConstants.ADDRESS_START_TAG + address + IMedicalAidConstants.ADDRESS_END_TAG);
						sbuf.append("\n" + IMedicalAidConstants.CONTACT_START_TAG + contact + IMedicalAidConstants.CONTACT_END_TAG);
						sbuf.append("\n" + IMedicalAidConstants.DISTANCE_START_TAG + distance + IMedicalAidConstants.DISTANCE_END_TAG);
						sbuf.append("\n" + IMedicalAidConstants.LONGITUDE_START_TAG + longitudeStr + IMedicalAidConstants.LONGITUDE_END_TAG);
						sbuf.append("\n" + IMedicalAidConstants.LATITUDE_START_TAG + latitudeStr + IMedicalAidConstants.LATITUDE_END_TAG);
						sbuf.append("\n" + IMedicalAidConstants.AMBULANCE_END_TAG);

					}// if Boolean
				}// end of if clause
			}// end for
			
			sbuf.append("\n" + IMedicalAidConstants.AMBULANCE_HEADER_END_TAG+"\n");	
			ambulanceXml = sbuf.toString();
			System.out.println(ambulanceXml);

		} catch (Exception e) {

			System.out.println(e.toString());
		}
		return ambulanceXml;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AmbulanceHelper ahelper = new AmbulanceHelper();
		ahelper.getAmbulanceList(5.3, 4.6);

	}
}