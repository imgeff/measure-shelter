package com.agro.techfields.dto;

import javax.validation.constraints.Size;

public class AtualizarIlhaDto extends PlantacaoIlhaDto {

  @Size(min = 3,  max = 12, message = "O campo area precisa ter entre 3 e 12 caracteres")
  private String area;

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }
}
