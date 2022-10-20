package com.agro.techfields.dto;

import org.bson.types.ObjectId;

public class IlhaDto {
  private ObjectId plantacaoId;

  private float area;

  public IlhaDto() {}

  public IlhaDto(float area) {
    this.area = area;
  }

  public ObjectId getPlantacaoId() {
    return plantacaoId;
  }

  public void setPlantacaoId(ObjectId plantacaoId) {
    this.plantacaoId = plantacaoId;
  }

  public float getArea() {
    return area;
  }

  public void setArea(float area) {
    this.area = area;
  }

}
