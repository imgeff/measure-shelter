package com.agro.techfields.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

public class Medida {
  public ObjectId id;

  private String umidadeDoAr;

  private String umidadeDoSolo;

  private String temperatura;

  private LocalDateTime data;

  public Medida() {
    this.data = LocalDateTime.now();
  }

  /**
   * Cria uma nova medida com base nos parâmetros passados.
   * @param umidadeDoAr
   * medida da umidade do ar
   * @param umidadeDoSolo
   * medida da umidade do solo
   * @param temperatura
   * medida da temperatura
   */
  public Medida(String umidadeDoAr, String umidadeDoSolo, String temperatura) {
    this.umidadeDoAr = umidadeDoAr;
    this.umidadeDoSolo = umidadeDoSolo;
    this.temperatura = temperatura;
    this.data = LocalDateTime.now();
  }

  public ObjectId getId() {
    return id;
  }

  public String getUmidadeDoAr() {
    return umidadeDoAr;
  }

  public String getUmidadeDoSolo() {
    return umidadeDoSolo;
  }

  public String getTemperatura() {
    return temperatura;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setUmidadeDoAr(String umidadeDoAr) {
    this.umidadeDoAr = umidadeDoAr;
  }

  public void setUmidadeDoSolo(String umidadeDoSolo) {
    this.umidadeDoSolo = umidadeDoSolo;
  }

  public void setTemperatura(String temperatura) {
    this.temperatura = temperatura;
  }
}
