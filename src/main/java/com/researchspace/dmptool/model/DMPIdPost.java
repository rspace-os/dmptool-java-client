package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.researchspace.dmptool.model.DMPIdType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DMPIdPost {

	@JsonProperty("type")
	DMPIdType idType;

	@JsonProperty("identifier")
	String identifier;

}
