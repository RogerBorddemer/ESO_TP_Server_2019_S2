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

//autre solution qui permet le mapping via http://www.jsonschema2pojo.org/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"uic",
	"libPr"
})
public class LieuOrigine implements Serializable
{

	@JsonProperty("uic")
	private String uic;
	@JsonProperty("libPr")
	private String libPr;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -8355034833717708569L;

	@JsonProperty("uic")
	public String getUic() {
		return uic;
	}

	@JsonProperty("uic")
	public void setUic(String uic) {
		this.uic = uic;
	}

	@JsonProperty("libPr")
	public String getLibPr() {
		return libPr;
	}

	@JsonProperty("libPr")
	public void setLibPr(String libPr) {
		this.libPr = libPr;
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
