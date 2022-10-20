package com.agro.techfields;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import com.agro.techfields.model.Imagem;
import com.agro.techfields.model.Plantacao;
import com.agro.techfields.repository.PlantacaoRepository;
import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.Test;


@QuarkusTest
public class ImagemControllerTest {

  @Inject
  PlantacaoRepository plantacaoRepository;

  @Test
  public void testBuscarImagens() {
    Plantacao plantacao = new Plantacao("Soja");
    this.plantacaoRepository.persist(plantacao);
    Imagem imagem = new Imagem("https://agropos.com.br/wp-content/uploads/2022/08/PLANTACAO-DE-SOJA.jpg");
    plantacao.addImagem(imagem);
    this.plantacaoRepository.update(plantacao);

    given()
        .contentType(MediaType.APPLICATION_JSON)
        .when()
        .get("/imagem/" + plantacao.getId())
        .then()
        .statusCode(Status.OK.getStatusCode())
        .body("size()", is(1), "url", hasItem(imagem.getUrl()));

  }
  
}
