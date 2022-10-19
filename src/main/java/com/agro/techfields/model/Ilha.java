package com.agro.techfields.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Ilha {
  public ObjectId id = new ObjectId();

  private float area;

  private List<Medida> medidas;

  public Ilha() {
    this.medidas = new ArrayList<Medida>();
  }

  /**
   * Cria uma nova Ilha.
   * @param area
   * área da ilha a ser criada
   */
  public Ilha(float area) {
    this.area = area;
    this.medidas = new ArrayList<Medida>();
  }

  public ObjectId getId() {
    return id;
  }

  public float getArea() {
    return area;
  }

  public List<Medida> getMedidas() {
    return medidas;
  }

  public void setArea(float area) {
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
