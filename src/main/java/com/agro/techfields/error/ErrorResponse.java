package com.agro.techfields.error; 

public class ErrorResponse {

  private String mensagem;

  public ErrorResponse(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getMensagem() {
    return mensagem;
  }
}
