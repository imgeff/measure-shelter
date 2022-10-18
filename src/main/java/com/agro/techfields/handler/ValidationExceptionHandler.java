package com.agro.techfields.handler;

import com.agro.techfields.error.ErrorResponse;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class  ValidationExceptionHandler implements ExceptionMapper<ValidationException> {

  @Override
  public Response toResponse(ValidationException exception) {
    String mensagemErro = exception.getLocalizedMessage();
    ErrorResponse erro = new ErrorResponse(mensagemErro);
    return Response.status(Status.BAD_REQUEST).entity(erro).build();
  }
  
}
