package com.agro.techfields.dto;

import javax.validation.constraints.Size;

import org.bson.types.ObjectId;

public class MedidaDto {
  
  private ObjectId plantacaoId;

  private ObjectId ilhaId;

  @Size(min = 2, message = "O campo umidadeDoAr deve ter mais de 2 caracteres")
  private String umidadeDoAr;

  @Size(min = 2, message = "O campo umidadeDoSolo deve ter mais de 2 caracteres")
  private String umidadeDoSolo;

  @Size(min = 2, message = "O campo temperatura deve ter mais de 2 caracteres")
  private String temperatura;

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

  public String getUmidadeDoAr() {
    return umidadeDoAr;
  }

  public void setUmidadeDoAr(String umidadeDoAr) {
    this.umidadeDoAr = umidadeDoAr;
  }

  public String getUmidadeDoSolo() {
    return umidadeDoSolo;
  }

  public void setUmidadeDoSolo(String umidadeDoSolo) {
    this.umidadeDoSolo = umidadeDoSolo;
  }

  public String getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(String temperatura) {
    this.temperatura = temperatura;
  }

}
