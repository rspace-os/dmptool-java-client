package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Optional;
import com.researchspace.rda.model.DMP;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Data
@NoArgsConstructor
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName(value = "dmp")
public class DMPToolDMP extends DMP {

	private Long id;

  @JsonProperty("dmproadmap_links")
  private Map<String, String> links;

  @JsonProperty("id")
  public void setId() {
		// Map<String,String> links = (Map<String,String>) dmp.get("dmproadmap_links");
		String getUrlString = links.get("get");
		String idString = getUrlString.substring(getUrlString.lastIndexOf("/") + 1);

    this.id = Long.parseLong(idString); 
	}
  // we want to use @JsonGetter to define a method that just gets the id

	public DMPToolDMP(Long id, String title, String description) {
		super();
		this.setTitle(title);
		this.setDescription(description);
		this.id = id;
	}

	// can I avoid this? It means that the other properties of DMP are not getting parsed
  // is there a way of delegating all other properties to the standard parsing but still be able to parse the id in this whacky way?
  // Is this class really being passed { dmp: { ... } } ??
	// @SuppressWarnings("unchecked")
	// @JsonProperty("dmp")
	// private void foo(Map<String,Object> dmp) {
	// 	this.setTitle((String) dmp.get("title"));
	// 	this.setDescription(Optional.of((String) dmp.get("description")));

	// 	Map<String,String> links = (Map<String,String>) dmp.get("dmproadmap_links");
	// 	String getUrlString = links.get("get");
	// 	String idString = getUrlString.substring(getUrlString.lastIndexOf("/") + 1);

	// 	try {
	// 	 this.id = Long.parseLong(idString); 
	// 	} catch (NumberFormatException e) {
	// 	 // ignore
	// 	}
	// }
}
