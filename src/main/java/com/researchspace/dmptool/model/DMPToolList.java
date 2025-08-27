package com.researchspace.dmptool.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.LinkedList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DMPToolList {

  private Integer page;

  @JsonAlias({"per_page"})
  private Integer perPage;

  @JsonAlias({"total_items"})
  private Integer totalItems;

  private List<DMPTooItem> items;

  public void setDmpItems(List<DMPToolDMP> dmpItems) {
    this.items = new LinkedList<>();
    for (DMPToolDMP dmpItem : dmpItems) {
      this.items.add(new DMPTooItem(dmpItem));
    }
  }

}

