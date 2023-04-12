package com.researchspace.dmptool.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DMP {

 private Long id;
 private String title;
 private String description;

 @SuppressWarnings("unchecked")
 @JsonProperty("dmp")
 private void unpackNested(Map<String,Object> dmp) {
  this.title = (String) dmp.get("title");
  this.description = (String) dmp.get("description");
  
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
