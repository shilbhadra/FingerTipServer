package com.ibm.techathon.helper;

public class FingerTipMedicalAidHelper {
	String address= null;
	public String getAmbulance(String lattitude,String longitude){
		AmbulanceHelper amHelper=new AmbulanceHelper();
		address=amHelper.getAmbulanceList(Double.parseDouble(lattitude), Double.parseDouble(longitude));
		//System.out.print("Fingertip\n" + amDet);
		return address;
	}
	public String getHospital(String lattitude,String longitude){
		HospitalHelper hpHelper=new HospitalHelper();
		address=hpHelper.getHospitalList(Double.parseDouble(lattitude), Double.parseDouble(longitude));
		//System.out.print("Fingertip\n" + amDet);
		return address; 
	}
	public String getDoctors(String lattitude,String longitude){
		DoctorHelper dcHelper=new DoctorHelper();
		address=dcHelper.getDoctorList(Double.parseDouble(lattitude), Double.parseDouble(longitude));
		return address;
	}
	public String getMedicineStore(String location){
		address="Medicine Store Details";
		return address;
	}
}
