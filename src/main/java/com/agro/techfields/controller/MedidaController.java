package com.agro.techfields.controller;

import com.agro.techfields.dto.MedidaDto;
import com.agro.techfields.model.Medida;
import com.agro.techfields.service.MedidaService;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.types.ObjectId;


@Path("/medida")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedidaController {
  
  @Inject
  private MedidaService medidaService;

  @GET
  @Path("/{nomePlantacao}/{ilhaId}")
  public Response buscarMedidas(
      @PathParam("nomePlantacao") String nomePlantacao, 
      @PathParam("ilhaId") ObjectId ilhaId
  ) {
    List<Medida> medidas = this.medidaService.buscarMedidas(nomePlantacao, ilhaId);
    return Response.status(Status.OK).entity(medidas).build();
  }

  @POST
  public Response criarMedida(MedidaDto medida) {
    Medida medidaCriada = this.medidaService.criarMedida(medida);
    return Response.status(Status.CREATED).entity(medidaCriada).build();
  }

  @PUT
  @Path("/{medidaId}")
  public Response atualizarMedida(@PathParam("medidaId") ObjectId medidaId, MedidaDto medida) {
    Medida medidaAtualizada = this.medidaService.atualizarMedida(medidaId, medida);
    return Response.status(Status.OK).entity(medidaAtualizada).build();
  }

}
