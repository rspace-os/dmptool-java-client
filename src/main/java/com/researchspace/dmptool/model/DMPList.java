package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class DMPList {

	private Integer page;
	
	@JsonAlias({"per_page"})
	private Integer perPage;
	
	@JsonAlias({"total_items"})
	private Integer totalItems;
	
	List<DMPToolDMP> items = new ArrayList<>();

}

