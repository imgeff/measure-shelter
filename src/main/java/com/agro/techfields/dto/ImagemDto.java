package com.agro.techfields.dto;

import org.bson.types.ObjectId;

public class ImagemDto {

  private ObjectId plantacaoId;
  private String url;

  public ObjectId getPlantacaoId() {
    return plantacaoId;
  }

  public void setPlantacaoId(ObjectId plantacaoId) {
    this.plantacaoId = plantacaoId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
