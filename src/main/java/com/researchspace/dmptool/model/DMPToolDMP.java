package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Optional;
import com.researchspace.rda.model.DMP;

@Data
@NoArgsConstructor
public class DMPToolDMP extends DMP {

	private Long id;

	public DMPToolDMP(Long id, String title, String description) {
		super();
		this.setTitle(title);
		this.setDescription(Optional.of(description));
		this.id = id;
	}

	// can I avoid this? It means that the other properties of DMP are not getting parsed
	@SuppressWarnings("unchecked")
	@JsonProperty("dmp")
	private void unpackNested(Map<String,Object> dmp) {
		this.setTitle((String) dmp.get("title"));
		this.setDescription(Optional.of((String) dmp.get("description")));

		Map<String,String> links = (Map<String,String>) dmp.get("dmproadmap_links");
		String getUrlString = links.get("get");
		String idString = getUrlString.substring(getUrlString.lastIndexOf("/") + 1);

		try {
		 this.id = Long.parseLong(idString); 
		} catch (NumberFormatException e) {
		 // ignore
		}
	}
}
