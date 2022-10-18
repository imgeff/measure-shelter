package com.agro.techfields.handler;

import com.agro.techfields.error.ErrorResponse;
import com.agro.techfields.error.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;


public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

  @Override
  public Response toResponse(NotFoundException exception) {
    String mensagemErro = exception.getMessage();
    ErrorResponse erro = new ErrorResponse(mensagemErro);
    return Response.status(Status.NOT_FOUND).entity(erro).build();
  }
  
}
