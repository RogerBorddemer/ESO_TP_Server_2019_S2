package com.dto;

import java.io.Serializable;


public class LieuMission implements Serializable {	
	
	/**
	 * Serial IUD for serialization.
	 */
	private static final long serialVersionUID = 6037181396472147356L;
	
	private String UIC;	
	private String LibPr;
	
	public String getUIC() {
		return UIC;
	}
	public void setUIC(String uIC) {
		UIC = uIC;
	}
	public String getLibPr() {
		return LibPr;
	}
	public void setLibPr(String libPr) {
		LibPr = libPr;
	}	
	
	

}
