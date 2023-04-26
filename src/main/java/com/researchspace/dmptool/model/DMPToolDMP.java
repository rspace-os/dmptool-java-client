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

	@JsonProperty("dmproadmap_links")
	private Map<String, String> links;

	/*
	 * This is... unfortunate. Would be much better for us to be using the
	 * proper dmp_id property as a unique identifier, rather than the
	 * internal implementation detail used by DMPTool. However, it is now
	 * used as a database key (UserDMP) so removing this without breaking
	 * backwards compatibility will be difficult.
	 */
	public Long getId() {
		String getUrlString = this.links.get("get");
		String idString = getUrlString.substring(getUrlString.lastIndexOf("/") + 1);
		return Long.parseLong(idString);
	}

}
