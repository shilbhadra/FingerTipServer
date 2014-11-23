package com.ibm.techathon.helper;

import java.text.DecimalFormat;

public class UtilityHelper {

	
	
	private String distance;

	public boolean checkLocationValidity(double lat1, double lon1,
			double lat2, double lon2) {
		
		char unit = 'K';
		// check x co-ordinate
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515 * 1.609344;

		if (dist > 5)
		{
			return false;
		}
		else
		{
			//DecimalFormat df = new DecimalFormat("#.##");
			//df.format(dist);
			//String.format("%.5g%n", 0.912300);
			distance=String.format("%.2f",+dist);
			return true;
		}

		
	}
	
	public String getCalculatedDistance()
	{
		
		return distance;
		
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
