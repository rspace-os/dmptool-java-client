package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.researchspace.rda.model.DMP;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DMPToolDMP extends DMP {

  @JsonProperty("dmproadmap_links")
  private Map<String, String> links;


  public String getDmpLink() {
    if (this.links != null) {
      return this.links.get("get");
    } else {
      return super.getDmpLink();
    }
  }

}
