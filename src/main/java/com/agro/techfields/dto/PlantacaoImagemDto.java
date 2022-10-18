package com.agro.techfields.dto;

import org.bson.types.ObjectId;

public class PlantacaoImagemDto {

  private ObjectId plantacaoId;
  private ObjectId imagemId;

  public ObjectId getPlantacaoId() {
    return plantacaoId;
  }

  public void setPlantacaoId(ObjectId plantacaoId) {
    this.plantacaoId = plantacaoId;
  }

  public ObjectId getImagemId() {
    return imagemId;
  }

  public void setImagemId(ObjectId imagemId) {
    this.imagemId = imagemId;
  }

}
