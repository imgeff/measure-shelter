package com.agro.techfields.controller;

import com.agro.techfields.dto.IlhaDto;
import com.agro.techfields.model.Ilha;
import com.agro.techfields.service.IlhaService;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.types.ObjectId;


@Path("/ilha")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IlhaController {

  @Inject
  private IlhaService ilhaService;

  @GET
  @Path("/{plantacaoId}")
  public Response buscarIlhas(@PathParam("plantacaoId") ObjectId plantacaoId) {
    List<Ilha> ilhas = this.ilhaService.buscarIlhas(plantacaoId);
    return Response.status(Status.OK).entity(ilhas).build();
  }

  @POST
  public Response criarIlha(IlhaDto ilha) {
    Ilha ilhaCriada = this.ilhaService.criarIlha(ilha);
    return Response.status(Status.CREATED).entity(ilhaCriada).build();
  }
}
