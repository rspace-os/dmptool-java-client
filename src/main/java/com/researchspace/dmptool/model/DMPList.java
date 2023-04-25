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
	
	List<DMPWrapper> items = new ArrayList<>();

	// @SuppressWarnings("unchecked")
	// @JsonProperty("items")
	// private void unpackNested(List<Map<String, Object>> objs) {

    // List<DMPToolDMP> items = new ArrayList<>();
    // for(Map<String, Object> obj : objs) {
      // items.add((DMPToolDMP) obj.get("dmp")); // this casting don't work
    // }
    // // return items;
    // this.items = items;



    // this.items = (List<DMPToolDMP>) 
		// this.setTitle((String) dmp.get("title"));
		// this.setDescription(Optional.of((String) dmp.get("description")));

		// Map<String,String> links = (Map<String,String>) dmp.get("dmproadmap_links");
		// String getUrlString = links.get("get");
		// String idString = getUrlString.substring(getUrlString.lastIndexOf("/") + 1);

		// try {
		 // this.id = Long.parseLong(idString); 
		// } catch (NumberFormatException e) {
		 // // ignore
		// }
	// }
}

