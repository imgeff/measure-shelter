package com.agro.techfields.error;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String recurso) {
    super(recurso + " Não encontrado!");
  }
}
