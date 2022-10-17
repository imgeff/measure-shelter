package com.agro.techfields.dto;

import org.bson.types.ObjectId;

public class PlantacaoIlhaDto {

  /**
   * Atributos
   */
  private ObjectId plantacaoId;
  private ObjectId ilhaId;

  /**
   * Métodos
   */
  public ObjectId getPlantacaoId() {
    return plantacaoId;
  }

  public void setPlantacaoId(ObjectId plantacaoId) {
    this.plantacaoId = plantacaoId;
  }

  public ObjectId getIlhaId() {
    return ilhaId;
  }

  public void setIlhaId(ObjectId ilhaId) {
    this.ilhaId = ilhaId;
  }

}
