package com.agro.techfields.dto;

import javax.validation.constraints.Size;

import org.bson.types.ObjectId;

public class IlhaDto {
  private ObjectId plantacaoId;

  @Size(min = 3,  max = 12, message = "O campo area precisa ter entre 3 e 12 caracteres")
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
