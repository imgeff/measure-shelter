package com.agro.techfields.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;

public class Imagem {
  
  public ObjectId id;

  private String url;

  private LocalDate data;

  public Imagem() {
    this.data = LocalDate.now();
  }

  public Imagem(String url) {
    this.url = url;
    this.data = LocalDate.now();
  }

  public ObjectId getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public LocalDate getData() {
    return data;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
