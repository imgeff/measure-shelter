package com.agro.techfields.dto;

import org.bson.types.ObjectId;

public class IlhaDto {
  private ObjectId plantacaoId;

  private String area;

  public ObjectId getPlantacaoId() {
    return plantacaoId;
  }

  public void setPlantacaoId(ObjectId plantacaoId) {
    this.plantacaoId = plantacaoId;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

}
