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
public class DMPWrapper {

  private DMPToolDMP dmp;

  public DMPWrapper(DMPToolDMP dmp) {
    this.dmp = dmp;
  }

}

