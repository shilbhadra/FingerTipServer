package com.ibm.techathon.helper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class HospitalHelper {


	String fileName = "Hospital.xml";
	String id;
	String name;
	String address;
	String contact;
	String distance;
	String department;
	String latitudeStr;
	String longitudeStr;
	private double xLattitude;
	private double yLongitude;

	HospitalHelper() {

	} 

	public String getHospitalList(double latitude, double longitude) {

		int i = 0;
		String hospitalXml = "";
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			 Document hospDoc = builder.parse(getClass().getResourceAsStream(fileName));
			
			 hospDoc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is "
					+ hospDoc.getDocumentElement().getNodeName());
			UtilityHelper uHelper=new UtilityHelper();
			NodeList listOfHospitals = hospDoc.getElementsByTagName("hospital");
			int totalHospitals = listOfHospitals.getLength();
			System.out.println("Total no of hospital : " + totalHospitals);
			StringBuffer sbuf = new StringBuffer(hospitalXml);
			sbuf.append(IMedicalAidConstants.HOSPITAL_HEADER_START_TAG);
			for (i = 0; i < totalHospitals; i++) {
				Node currNode = listOfHospitals.item(i);
				if (currNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstHospitalElement = (Element) currNode;

					// -------xCol--
					NodeList xCoList = firstHospitalElement
							.getElementsByTagName("xCoordinate");
					Element xCoElement = (Element) xCoList.item(0);
					NodeList textxCoList = xCoElement.getChildNodes();
					xLattitude = Double.parseDouble(textxCoList.item(0)
							.getNodeValue().trim());
					// -- end

					// -------yCol--
					NodeList yCoList = firstHospitalElement
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

						NodeList nameList = firstHospitalElement
								.getElementsByTagName("name");
						Element nameElement = (Element) nameList.item(0);
						NodeList textNameList = nameElement.getChildNodes();
						name = textNameList.item(0).getNodeValue().trim();
						// -- end

						// -------ID--
						NodeList iDList = firstHospitalElement
								.getElementsByTagName("id");
						Element idElement = (Element) iDList.item(0);
						NodeList textIdList = idElement.getChildNodes();
						id = textIdList.item(0).getNodeValue().trim();
						// -- end

						// -------Address--
						NodeList addressList = firstHospitalElement
								.getElementsByTagName("address");
						Element addressElement = (Element) addressList.item(0);
						NodeList textAddressList = addressElement
								.getChildNodes();
						address = textAddressList.item(0).getNodeValue().trim();
						// -- end

						// -------Contact--
						NodeList contactList = firstHospitalElement
								.getElementsByTagName("contact");
						Element contactElement = (Element) contactList.item(0);
						NodeList textContactList = contactElement
								.getChildNodes();
						contact = textContactList.item(0).getNodeValue().trim();
						// -- end

						// -------Department
						NodeList deptList = firstHospitalElement
								.getElementsByTagName("department");
						Element deptElement = (Element) deptList.item(0);
						NodeList textDeptList = deptElement
								.getChildNodes();
						department = textDeptList.item(0).getNodeValue().trim();
						
						// -- end
						
						// -------Latitude--
						NodeList latitudeList = firstHospitalElement.getElementsByTagName("xCoordinate");
						Element latitudeElement = (Element) latitudeList.item(0);
						NodeList textlatitudeList = latitudeElement.getChildNodes();
						latitudeStr = textlatitudeList.item(0).getNodeValue().trim();
						// -- end
						
						// -------Longitude--
						NodeList longitudeList = firstHospitalElement.getElementsByTagName("yCoordinate");
						Element longitudeElement = (Element) longitudeList.item(0);
						NodeList textlongitudeList = longitudeElement.getChildNodes();
						longitudeStr = textlongitudeList.item(0).getNodeValue().trim();
						// -- end
						
					
						distance=uHelper.getCalculatedDistance();
						
				sbuf.append("\n" + IMedicalAidConstants.HOSPITAL_START_TAG);
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
				sbuf.append("\n" + IMedicalAidConstants.DEPT_START_TAG
						+ department + IMedicalAidConstants.DEPT_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.LONGITUDE_START_TAG + longitudeStr + IMedicalAidConstants.LONGITUDE_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.LATITUDE_START_TAG + latitudeStr + IMedicalAidConstants.LATITUDE_END_TAG);
				sbuf.append("\n" + IMedicalAidConstants.HOSPITAL_END_TAG);
				
				
					}// if Boolean
				}// end of if clause
			}// end for
			sbuf.append("\n" + IMedicalAidConstants.HOSPITAL_HEADER_END_TAG+"\n");	
			hospitalXml =sbuf.toString();
			System.out.println(hospitalXml);

		} catch (Exception e) {

			System.out.println(e.toString());
		}
		return hospitalXml;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HospitalHelper ahelper = new HospitalHelper();
		ahelper.getHospitalList(5.3, 4.6);

	}
}
