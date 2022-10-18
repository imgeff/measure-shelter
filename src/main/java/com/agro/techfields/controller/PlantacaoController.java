package com.agro.techfields.controller;

import com.agro.techfields.dto.PlantacaoDto;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.service.PlantacaoService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/plantacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlantacaoController {

  @Inject
  PlantacaoService plantacaoService;

  @POST
  public Response criarPlantacao(PlantacaoDto plantacao) {
    Plantacao plantacaoCriada = this.plantacaoService.criarPlantacao(plantacao);
    return Response.status(Status.CREATED).entity(plantacaoCriada).build();
  }
}
