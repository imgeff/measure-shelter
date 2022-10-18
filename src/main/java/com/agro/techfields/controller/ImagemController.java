package com.agro.techfields.controller;

import com.agro.techfields.dto.ImagemDto;
import com.agro.techfields.dto.PlantacaoImagemDto;
import com.agro.techfields.model.Imagem;
import com.agro.techfields.service.ImagemService;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
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


@Path("/imagem")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ImagemController {
  
  @Inject
  private ImagemService imagemService;

  @GET
  public Response baixarImagem(@Valid PlantacaoImagemDto plantacaoImagemDto) {
    Imagem imagem = this.imagemService.baixarImagem(plantacaoImagemDto);
    return Response.status(Status.OK).entity(imagem).build();
  }

  @GET
  @Path("/{plantacaoId}")
  public Response buscarImagens(@PathParam("plantacaoId") ObjectId plantacaoId) {
    List<Imagem> imagens = this.imagemService.buscarImagens(plantacaoId);
    return Response.status(Status.OK).entity(imagens).build();
  }

  @POST
  public Response inserirImagem(@Valid ImagemDto imagem) {
    Imagem imagemCriada = this.imagemService.inserirImagem(imagem);
    return Response.status(Status.CREATED).entity(imagemCriada).build();
  }
  
}
