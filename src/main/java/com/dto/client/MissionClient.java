package com.dto.client;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// autre solution qui permet le mapping via http://www.jsonschema2pojo.org/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"numeroTrain",
	"dateCirculation",
	"horaireDepart",
	"horaireDestination",
	"lieuOrigine",
	"lieuDestination"
})
public class MissionClient implements Serializable
{

	@JsonProperty("numeroTrain")
	private String numeroTrain;
	@JsonProperty("dateCirculation")
	private String dateCirculation;
	@JsonProperty("horaireDepart")
	private String horaireDepart;
	@JsonProperty("horaireDestination")
	private String horaireDestination;
	@JsonProperty("lieuOrigine")
	private LieuOrigine lieuOrigine;
	@JsonProperty("lieuDestination")
	private LieuDestination lieuDestination;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 7561914431892498010L;

	@JsonProperty("numeroTrain")
	public String getNumeroTrain() {
		return numeroTrain;
	}

	@JsonProperty("numeroTrain")
	public void setNumeroTrain(String numeroTrain) {
		this.numeroTrain = numeroTrain;
	}

	@JsonProperty("dateCirculation")
	public String getDateCirculation() {
		return dateCirculation;
	}

	@JsonProperty("dateCirculation")
	public void setDateCirculation(String dateCirculation) {
		this.dateCirculation = dateCirculation;
	}

	@JsonProperty("horaireDepart")
	public String getHoraireDepart() {
		return horaireDepart;
	}

	@JsonProperty("horaireDepart")
	public void setHoraireDepart(String horaireDepart) {
		this.horaireDepart = horaireDepart;
	}

	@JsonProperty("horaireDestination")
	public String getHoraireDestination() {
		return horaireDestination;
	}

	@JsonProperty("horaireDestination")
	public void setHoraireDestination(String horaireDestination) {
		this.horaireDestination = horaireDestination;
	}

	@JsonProperty("lieuOrigine")
	public LieuOrigine getLieuOrigine() {
		return lieuOrigine;
	}

	@JsonProperty("lieuOrigine")
	public void setLieuOrigine(LieuOrigine lieuOrigine) {
		this.lieuOrigine = lieuOrigine;
	}

	@JsonProperty("lieuDestination")
	public LieuDestination getLieuDestination() {
		return lieuDestination;
	}

	@JsonProperty("lieuDestination")
	public void setLieuDestination(LieuDestination lieuDestination) {
		this.lieuDestination = lieuDestination;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
