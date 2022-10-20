package com.agro.techfields.dto;

import javax.validation.constraints.Size;

public class PlantacaoDto {

  @Size(min = 3, message = "O campo nome deve ter mais de 3 caracteres")
  private String nome;

  public PlantacaoDto() {}

  public PlantacaoDto(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  
}
