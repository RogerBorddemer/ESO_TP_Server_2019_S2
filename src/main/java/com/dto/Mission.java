package com.dto;

import java.io.Serializable;


public class Mission implements Serializable {	
	
	/**
	 * Serial IUD for serialization.
	 */
	private static final long serialVersionUID = -8050478362033217382L;
	
	private int id;
	private String numeroTrain;
	private String dateCirculation;
	private String horaireDepart;
	private String horaireDestination;	
	private LieuMission lieuOrigine;	
	private LieuMission lieuDestination;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroTrain() {
		return numeroTrain;
	}
	public void setNumeroTrain(String numeroTrain) {
		this.numeroTrain = numeroTrain;
	}
	public String getDateCirculation() {
		return dateCirculation;
	}
	public void setDateCirculation(String dateCirculation) {
		this.dateCirculation = dateCirculation;
	}
	public String getHoraireDepart() {
		return horaireDepart;
	}
	public void setHoraireDepart(String horaireDepart) {
		this.horaireDepart = horaireDepart;
	}
	public String getHoraireDestination() {
		return horaireDestination;
	}
	public void setHoraireDestination(String horaireDestination) {
		this.horaireDestination = horaireDestination;
	}
	public LieuMission getLieuOrigine() {
		return lieuOrigine;
	}
	public void setLieuOrigine(LieuMission lieuOrigine) {
		this.lieuOrigine = lieuOrigine;
	}
	public LieuMission getLieuDestination() {
		return lieuDestination;
	}
	public void setLieuDestination(LieuMission lieuDestination) {
		this.lieuDestination = lieuDestination;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	

}
