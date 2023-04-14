package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DMPList {

	private Integer page;
	
	@JsonAlias({"per_page"})
	private Integer perPage;
	
	@JsonAlias({"total_items"})
	private Integer totalItems;
	
	List<DMPToolDMP> items = new ArrayList<>();

}

