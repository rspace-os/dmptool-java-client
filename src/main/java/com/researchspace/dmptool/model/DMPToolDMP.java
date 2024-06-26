package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.researchspace.rda.model.DMP;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName(value = "dmp")
@JsonIgnoreProperties(ignoreUnknown=true)
public class DMPToolDMP extends DMP {

	@JsonProperty("dmproadmap_links")
	private Map<String, String> links;

	/*
	 * This is maintained for backwards compatibility and may be removed in the
	 * future in favour of using the dmp_id property as a unique identifier.
	 */
	public Long getId() {
		String getUrlString = this.links.get("get");
		String idString = getUrlString.substring(getUrlString.lastIndexOf("/") + 1);
		return Long.parseLong(idString);
	}

}
