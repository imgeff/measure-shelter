package com.agro.techfields.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Ilha {
  public ObjectId id;

  private String area;

  private List<Medida> medidas;

  public Ilha() {
    this.medidas = new ArrayList<Medida>();
  }

  public Ilha(String area) {
    this.area = area;
    this.medidas = new ArrayList<Medida>();
  }

  public ObjectId getId() {
    return id;
  }

  public String getArea() {
    return area;
  }

  public List<Medida> getMedidas() {
    return medidas;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public void setMedidas(List<Medida> medidas) {
    this.medidas = medidas;
  }

  /** Adiciona Medida ao array medidas. */
  public void addMedida(Medida medida) {
    this.medidas.add(medida);
  }

}
